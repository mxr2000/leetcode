package com.mxr.demo;

import java.util.HashSet;
import java.util.Set;

public class Problem136 {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (set.contains(value)) {
                set.remove(value);
            } else {
                set.add(value);
            }
        }
        return (int) set.toArray()[0];
    }

    public static void main(String[] args) {
        System.out.println((new Problem136()).singleNumber(new int[]{2, 2, 1}));
    }
}
