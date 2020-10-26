package com.example.demo.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * CollectionsTest3
 */
public class CollectionsTest3 {

    public static void main(String[] args) {
        System.out.println(Collections.emptyList());

        System.out.println(Collections.emptySet());

        System.out.println(Collections.emptyMap());

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(-1);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(-5);
        arrayList.add(7);
        arrayList.add(4);
        arrayList.add(-9);
        arrayList.add(-7);

        HashSet<Integer> integers1 = new HashSet<>();
        integers1.add(1);
        integers1.add(3);
        integers1.add(2);

        Map<String, Integer> scores = new HashMap<>();
        scores.put("语文" , 80);
        scores.put("Java" , 82);

        List<ArrayList<Integer>> arrayLists = Collections.singletonList(arrayList);
        System.out.println(arrayLists);

        Set<ArrayList<Integer>> singletonSet = Collections.singleton(arrayList);
        System.out.println(singletonSet);

        Map<String, String> nihao =  Collections.singletonMap("1", "nihao");
        System.out.println(nihao);

        List<Integer> integers = Collections.unmodifiableList(arrayList);
        System.out.println(integers);

        Set<Integer> integers2 = Collections.unmodifiableSet(integers1);
        System.out.println(integers2);

        System.out.println(Collections.unmodifiableMap(scores));


    }
}