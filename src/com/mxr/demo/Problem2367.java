package com.mxr.demo;

import java.util.Arrays;

public class Problem2367 {
    public int arithmeticTriplets(int[] nums, int diff) {
        int result = 0;
        int[] lasts = new int[diff], lengths = new int[diff];
        Arrays.fill(lasts, -diff - 1);
        for (int n : nums) {
            int mod = n % diff;
            if (n == lasts[mod] + diff) {
                ++lengths[mod];
            } else {
                lengths[mod] = 1;
            }
            if (lengths[mod] >= 3) {
                ++result;
            }
            lasts[mod] = n;
        }
        return result;
    }
}
