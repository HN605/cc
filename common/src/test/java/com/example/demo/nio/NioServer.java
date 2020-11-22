package com.example.demo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class NioServer {

    public static void main(String[] args) throws IOException {
        // 创建一个selector
        Selector selector = Selector.open();

        // 初始化TCP连接监听通道
        ServerSocketChannel listenChannel = ServerSocketChannel.open();
        listenChannel.bind(new InetSocketAddress(9999));
        listenChannel.configureBlocking(false);
        // 注册到selector（监听其ACCEPT事件）
        listenChannel.register(selector, SelectionKey.OP_ACCEPT);

        // 创建一个缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(100);

        //selector在实现时有bug,epool底层可能会发送一个错误的信号导致select方法提前返回，但没有
        //返回注册的事件，而且不断循环造成CPU100％
        int selectZeroCount = 0;
        int maxZeroCount = 20;
        int fixed = 0;

        while (true) {
            int count = selector.select(); //阻塞，直到有监听的事件发生

            if (count == 0) {
                selectZeroCount++;
            } else {
                //保证是连续的count==0时才将selectZeroCount++,如果其中有一次返回注册事件测已经正常
                selectZeroCount = 0;
            }

            if (selectZeroCount > maxZeroCount && fixed == 0) {
                for (SelectionKey key: selector.keys()) {
                    if (key.isValid() && key.interestOps() == 0) {
                        key.cancel();
                    }
                }
                fixed = 1;
            } else if (selectZeroCount > maxZeroCount && fixed == 1) {
                //如果已经干预过仍然连续返回0，注意如果不返回0的话selectZeroCount就被置0.
                //重新获取一个selector,将当前事件重新注册到新的selector上。并销毁当前selector
                Selector newSelector = Selector.open();
                changeSelector(selector, newSelector);
                selector = newSelector;
            }

            // 通过迭代器依次访问select出来的Channel事件
            Iterator<SelectionKey> keyIter = selector.selectedKeys().iterator();
            while (keyIter.hasNext()) {
                SelectionKey key = keyIter.next();

                if (key.isAcceptable()) { // 有连接可以接受
                    SocketChannel channel = ((ServerSocketChannel) key.channel()).accept();
                    channel.configureBlocking(false);
                    channel.register(selector, SelectionKey.OP_READ);

                    System.out.println("与【" + channel.getRemoteAddress() + "】建立了连接！");

                } else if (key.isReadable()) { // 有数据可以读取
                    buffer.clear();

                    // 读取到流末尾说明TCP连接已断开，
                    // 因此需要关闭通道或者取消监听READ事件
                    // 否则会无限循环
                    if (((SocketChannel) key.channel()).read(buffer) == -1) {
                        key.channel().close();
                        continue;
                    }

                    // 按字节遍历数据
                    buffer.flip();//读取buffer里的内容时一定要flip()
                    while (buffer.hasRemaining()) {
                        byte b = buffer.get();

                        if (b == 0) { // 客户端消息末尾的\0
                            System.out.println();

                            // 响应客户端
                            buffer.clear();
                            buffer.put("Hello, Client!\0".getBytes());
                            buffer.flip();//读取buffer里的内容时一定要flip()
                            while (buffer.hasRemaining()) {
                                ((SocketChannel) key.channel()).write(buffer);
                            }
                        } else {
                            System.out.print((char) b);
                        }
                    }
                }

                // 已经处理的事件一定要手动移除
                keyIter.remove();
            }
        }
    }

    private static void changeSelector(Selector oldSelector, Selector newSelector) {
        for (SelectionKey key : oldSelector.keys()) {
            if (!key.isValid() || key.interestOps() == 0) {
                continue;
            }
            Object att = key.attachment();
            try {
                if (att == null) {
                    key.channel().register(newSelector, key.interestOps());
                } else {
                    key.channel().register(newSelector, key.interestOps(), att);
                }
            } catch (ClosedChannelException e) {
                SocketChannel sc = (SocketChannel) key.channel();
                try {
                    sc.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        try {
            oldSelector.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
