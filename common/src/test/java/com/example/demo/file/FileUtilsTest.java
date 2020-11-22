package com.example.demo.file;

import com.example.demo.utils.FileUtils;

public class FileUtilsTest {
    public static void main(String[] args) {
        String str = "Est-ce possible que tu sois en train de penser à moi lorsque tu me manques?";

        String fileName = "logs/fileTest.txt";

        FileUtils.write(str, fileName, "ISO-8859-1");

        System.out.println(FileUtils.read(fileName, "ISO-8859-1"));
        System.out.println(FileUtils.read(fileName));
    }
}
