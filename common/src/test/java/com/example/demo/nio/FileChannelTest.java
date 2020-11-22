package com.example.demo.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;

public class FileChannelTest {
    public static void main(String[] args) {
        write();
        read();

    }

    public static void read() {
        try {
            FileChannel channel = new RandomAccessFile("logs/test.txt", "rw").getChannel();
            channel.position(0);

            CharsetDecoder decoder = StandardCharsets.UTF_8.newDecoder();

            CharBuffer charBuffer = CharBuffer.allocate(10);

            ByteBuffer byteBuffer = ByteBuffer.allocate(20);
            byteBuffer.clear();//limit=capacity,position=0

            while (channel.read(byteBuffer) != -1 || byteBuffer.position() > 0) {
                byteBuffer.flip();

                charBuffer.clear();
                decoder.decode(byteBuffer, charBuffer, false);
                System.out.println(charBuffer.flip());

                byteBuffer.compact();//数据可能有剩余
            }

            channel.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write() {

        try {
            FileChannel channel = new RandomAccessFile("logs/test.txt", "rw").getChannel();
            channel.position(channel.size());

            ByteBuffer byteBuffer = ByteBuffer.allocate(20);

            byteBuffer.put("你好，世界！\n".getBytes(StandardCharsets.UTF_8));
            byteBuffer.flip();//buffer中limit=position, position=0

            while(byteBuffer.hasRemaining()) {
                channel.write(byteBuffer);
            }

            channel.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
