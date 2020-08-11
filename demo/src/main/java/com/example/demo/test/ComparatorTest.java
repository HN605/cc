package com.example.demo.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;

import com.example.demo.entity.Person;

/**
 * ComparatorTest
 */
public class ComparatorTest {

    public static void main(String[] args) {
        Integer a = 2;
        Integer b = 1;
        System.out.println(a.compareTo(b));


        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(-1);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(-5);
        arrayList.add(7);
        arrayList.add(4);
        arrayList.add(-9);
        arrayList.add(-7);

        Collections.sort(arrayList);
        System.out.println(arrayList);

        Collections.sort(arrayList, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        System.out.println(arrayList);

        TreeMap<Person, String> pdata = new TreeMap<>();
        pdata.put(new Person("张三", 30), "zhangsan");
        pdata.put(new Person("李四", 20), "lisi");
        pdata.put(new Person("王五", 10), "wangwu");
        pdata.put(new Person("小红", 5), "xiaohong");

        Set<Person> keys = pdata.keySet();
        for (Person person : keys) {
            System.out.println(person.getAge() + "-" + person.getName());
        }

    }
}