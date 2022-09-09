package com.mxr.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem1630 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            result.add(check(nums, l[i], r[i]));
        }
        return result;
    }

    private boolean check(int[] nums, int left, int right) {
        if (right < left + 2) {
            return false;
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int i = left; i <= right; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            set.add(nums[i]);
        }
        if ((max - min) % (right - left) != 0) {
            return false;
        }
        int dif = (max - min) / (right - left);
        for (int i = 1; i < right - left; i++) {
            min += dif;
            if (!set.contains(min)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] l = {0, 0, 2}, r = {2, 3, 5};
        int[] nums = {4, 6, 5, 9, 3, 7};
        System.out.println((new Problem1630()).checkArithmeticSubarrays(nums, l, r));
    }
}
