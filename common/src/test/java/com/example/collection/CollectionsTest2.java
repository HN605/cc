package com.example.collection;

import java.util.ArrayList;
import java.util.Collections;

/**
 * CollectionsTest2
 */
public class CollectionsTest2 {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(-1);
		arrayList.add(3);
		arrayList.add(3);
		arrayList.add(-5);
		arrayList.add(7);
		arrayList.add(4);
		arrayList.add(-9);
		arrayList.add(-7);
		ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
		arrayList2.add(-3);
		arrayList2.add(-5);
        arrayList2.add(7);
        
        System.out.println(arrayList);

        System.out.println(Collections.max(arrayList));

        System.out.println(Collections.min(arrayList));

        System.out.println(Collections.replaceAll(arrayList, 3, -3));

        System.out.println(Collections.frequency(arrayList, -3));

        System.out.println(Collections.indexOfSubList(arrayList, arrayList2));

        //二分查找，返回索引。List必须是有序的
        Collections.sort(arrayList);
        System.out.println(arrayList);
        System.out.println(Collections.binarySearch(arrayList, 7));
    }
}