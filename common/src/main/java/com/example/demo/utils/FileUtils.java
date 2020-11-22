package com.example.demo.utils;

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
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), charsetName));
            StringBuffer str = new StringBuffer();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                str.append(line);
            }

            return str.toString();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return "";
    }

}
