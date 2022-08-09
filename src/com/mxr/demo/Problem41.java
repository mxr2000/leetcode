package com.mxr.demo;

import java.util.HashSet;
import java.util.Set;

public class Problem41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 1; i <= n + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 0;
    }
}
