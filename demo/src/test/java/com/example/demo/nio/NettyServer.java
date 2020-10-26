package com.example.demo.nio;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.UnsupportedEncodingException;

public class NettyServer {
    private static int HEADER_LENGTH = 4;

    public static void main(String[] args) {
        new NettyServer().bind(9999);
    }

    public void bind(int port) {
        //创建mainReactor
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        //创建工作线程组，包含SubReactor 和 Worker 线程
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup)//组NioEventLoop
                    .channel(NioServerSocketChannel.class)//设置channel类型为NIO类型
                    .option(ChannelOption.SO_BACKLOG, 1024)//设置连接配置参数
                    .childOption(ChannelOption.TCP_NODELAY, true)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    //配置入站出站事件handler
                    .childHandler(new ChannelInitializer<NioSocketChannel>() {
                        @Override
                        protected void initChannel(NioSocketChannel ch) {
                            ch.pipeline().addLast(new MessageHandler());
                        }
                    });
            //ChannelFuture f = bootstrap.bind(port).sync();
            ChannelFuture f = serverBootstrap.bind(port).addListener(future -> {
                if (future.isSuccess()) {
                    System.out.println("端口["+ port + "]绑定成功!");
                } else {
                    System.out.println("端口["+ port + "]绑定失败!");
                }
            });
            //f.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }

    private class MessageHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws UnsupportedEncodingException {
            ByteBuf in = (ByteBuf) msg;
            byte[] req = new byte[in.readableBytes()];
            in.readBytes(req);
            String body = new String(req, "utf-8");
            System.out.println("Receive message from client:" + body);
            //回写响应消息
            ctx.write(Unpooled.copiedBuffer("Success".getBytes()));
        }

        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
            ctx.flush();
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
            cause.printStackTrace();
            ctx.close();
        }
    }
}
