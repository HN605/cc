package com.example.file;

import com.example.entity.Good;

import java.util.Arrays;

/**
 * Comparable 和Comparator的区别
 */
public class ComparableTest {
    public static void main(String[] args) {
        Good[] goods = new Good[4];
        goods[0] = new Good("hwPhone", 5000);
        goods[1] = new Good("iPhone", 6000);
        goods[2] = new Good("xiaomiPhone", 3000);
        goods[3] = new Good("oppoPhone", 4000);

        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));

        //使用Comparator接口可以自定义排序方式
        Arrays.sort(goods, (good1, good2) -> {
            if (good1.getPrice() > good2.getPrice()) {
                return -1;
            } else if (good1.getPrice() < good2.getPrice()) {
                return 1;
            } else {
                return 0;
            }
        });

        System.out.println(Arrays.toString(goods));
    }
}
