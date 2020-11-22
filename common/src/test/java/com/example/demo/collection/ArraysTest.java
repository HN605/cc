package com.example.demo.collection;

import java.util.Arrays;
import java.util.List;

/**
 * ArraysTest
 */
public class ArraysTest {

    public static void main(String[] args) {
        int[] a = { 1, 3, 2, 7, 6, 5, 4, 9 };
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }

        System.out.println();

        int[] b = { 1, 3, 2, 7, 6, 5, 4, 9 };
        Arrays.sort(b, 2, 6);
        for (int i : b) {
            System.out.print(i);
        }

        System.out.println();

        int[] c = { 1, 3, 2, 7, 6, 5, 4, 9 };
        Arrays.parallelSort(c);
        for (int i : c) {
            System.out.print(i);
        }

        System.out.println();

        char[] d = { 'a', 'f', 'b', 'c', 'e', 'A', 'C', 'B' };
        Arrays.parallelSort(d);
        for (char d2 : d) {
            System.out.print(d2);
        }
        System.out.println();

        String[] strs = { "abcdehg", "abcdefg", "abcdeag" };
        Arrays.sort(strs);
        System.out.println(Arrays.toString(strs));

        char[] e = { 'a', 'f', 'b', 'c', 'e', 'A', 'C', 'B' };
        Arrays.sort(e);
        System.out.println(Arrays.toString(e));
        int s = Arrays.binarySearch(e, 'e');
        System.out.println(s);

        char[] f = { 'a', 'f', 'b', 'c', 'e', 'A', 'C', 'B' };
        System.out.println(Arrays.equals(e, f));

        int[] g = { 1, 2, 3, 3, 3, 3, 6, 6, 6 };
        Arrays.fill(g, 3);
        for (int i : g) {
            System.out.print(i);
        }
        System.out.println();

        int[] h = { 1, 2, 3, 3, 3, 3, 6, 6, 6, };
        Arrays.fill(h, 0, 2, 9);
        for (int i : h) {
            System.out.print(i);
        }
        System.out.println();

        List<String> strings = Arrays.asList("Larry", "Moe", "Curly");
        System.out.println(strings);

        char[] k = { 'a', 'f', 'b', 'c', 'e', 'A', 'C', 'B' };
        System.out.println(Arrays.toString(k));

        int[] j = { 1, 2, 3, 3, 3, 3, 6, 6, 6, };
        int[] l = Arrays.copyOf(j, 6);
        for (int i : l) {
            System.out.print(i);
        }
        System.out.println();

        int[] m = Arrays.copyOfRange(j, 6, 11);
        for (int i : m) {
            System.out.print(i);
        }
        System.out.println();
    }
}