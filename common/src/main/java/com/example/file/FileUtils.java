package com.example.file;

import java.io.*;

public class FileUtils {

    public static void write(String str, String fileName) {
        write(str, fileName);
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
        return read(fileName, "UTF-8");
    }

    public static String read(String fileName, String charsetName) {
        InputStreamReader fileReader = null;

        try {
            fileReader = new InputStreamReader(new FileInputStream(fileName), charsetName);
            int len = 0;
            StringBuffer str = new StringBuffer();
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
