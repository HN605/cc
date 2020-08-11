package com.example.demo;

import java.util.*;

public class Test {
    public static void main(String[] args) {

        int[] array = {2, 1, 4, 3, 7, 5, 6};

        maoPao(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println();

//        Test test = new Test();
//        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(8);
//
//        ListNode l2 = new ListNode(0);
//
//        ListNode res = test.addTwoNumbers(l1, l2);
//
//        while(res != null) {
//            System.out.println(res.val);
//            res= res.next;
//
//        }

    }

    public static void maoPao(int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i -1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }

        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int first = 0; first < n; first++) {
            if (nums[first] > 0) {
                return ans;
            }
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int third = n - 1;
            for (int second = first + 1; second < n; second++) {
                if (second > first + 1 && nums[second - 1] == nums[second]) {
                    continue;
                }

                while (second < third && nums[second] + nums[third] > -nums[first]) {
                    third--;
                }

                if (second == third) break;

                if (nums[first] + nums[second] + nums[third] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }

        return ans;
    }

    //最长共有前缀
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 0; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }

    //回文数 反转一半数字
    public boolean isPalindrome(int x) {
        if (x < 0 ||(x % 10 == 0 && x != 0)) {
            return false;
        }

        int reserveNumber = 0;
        while (x > reserveNumber) {
            reserveNumber = reserveNumber * 10 + x % 10;
            x /= 10;
        }

        return x == reserveNumber || x == reserveNumber / 10;
    }

    //数字反转
    public int reverse(int x) {
        int rev = 0;
        while(x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return  rev;
    }

    //最长的子字符串
    public int lengthOfLongestSubString(String s) {
        Set<Character> occ = new HashSet<>();
        int n = s.length();

        int rk = -1, ans = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                occ.remove(s.charAt(i - 1));
            }
            while(rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    //两个数字相加
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;

        while(null != p || null != q) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if(p != null) p = p.next;
            if(q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

    static class ListNode{
        int val;
        ListNode next = null;
        ListNode(int x) {val= x;}
    }

}

