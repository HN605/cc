package com.example.collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * ScannerTest
 */
public class ScannerTest {

    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        // for (int i = 0; i < 4; i++) {
        //     System.out.println("请输入：");
        //     String s = scanner.nextLine();
        //     System.out.println("this is " + s);
        // }
        // scanner.close();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            System.out.print("请输入：");
            String s = bufferedReader.readLine();
            System.out.println("this is " + s);
        }

        bufferedReader.close();

    }
}