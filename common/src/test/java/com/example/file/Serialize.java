package com.example.file;

import java.io.*;

public class Serialize implements Serializable {

    private static final long serialVersionUID = 1881843341745094931L;

    public int num = 1390;

    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("logs/serialize.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            Serializable serializable = new Serialize();
            oos.writeObject(serializable);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
