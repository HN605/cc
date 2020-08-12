package com.example.file;

import java.io.*;

public class FileUtils {

    public static void main(String[] args) {
        String str = "Est-ce possible que tu sois en train de penser à moi lorsque tu me manques?";

        String fileName = "logs/fileTest.txt";

        write(str, fileName, "ISO-8859-1");

        System.out.println(read(fileName, "ISO-8859-1"));
        System.out.println(read(fileName));
    }

    public static void write(String str, String fileName, String charsetName) {
        OutputStreamWriter fileWrite = null;
        try {
            fileWrite = new OutputStreamWriter(new FileOutputStream(fileName), charsetName);
            char[] chars = str.toCharArray();
            fileWrite.write(chars);
            fileWrite.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWrite != null) {
                    fileWrite.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static String read(String fileName) {
        return read(fileName, null);
    }

    public static String read(String fileName, String charsetName) {
        StringBuffer str = new StringBuffer();
        InputStreamReader fileReader = null;

        try {
            //FileReader f = new FileReader("file");
            if (charsetName == null) {
                fileReader = new InputStreamReader(new FileInputStream(fileName));
            } else {
                fileReader = new InputStreamReader(new FileInputStream(fileName), charsetName);
            }
            /*char[] buf = new char[1024];
            while (fileReader.read() > 0) {
                str.append(buf);
            }*/
            int len = 0;
            while( (len = fileReader.read()) > 0) {
                str.append((char) len);
            }

            return str.toString();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return "";
    }

}
