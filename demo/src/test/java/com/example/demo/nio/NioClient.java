package com.example.demo.nio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class NioClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 9999);


            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();

            String msg = "hello this is client!\0";
            out.write(msg.getBytes());

            int b;
            while ((b = in.read()) != 0) {
                System.out.print((char) b);
            }

            System.out.println();

            socket.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
