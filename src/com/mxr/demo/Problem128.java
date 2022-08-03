package com.mxr.demo;

import java.util.*;

public class Problem128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int result = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int cur = num;
                int length = 1;
                while (set.contains(cur + 1)) {
                    ++cur;
                    ++length;
                }
                result = Math.max(result, length);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println((new Problem128()).longestConsecutive(nums));
    }
}
