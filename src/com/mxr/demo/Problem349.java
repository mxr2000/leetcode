package com.mxr.demo;

import java.util.*;

public class Problem349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        for (int num :
                nums1) {
            s1.add(num);
        }
        for (int num :
                nums2) {
            s2.add(num);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : s1) {
            if (s2.contains(num)) {
                list.add(num);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
