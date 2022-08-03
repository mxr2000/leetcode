package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem670 {
    public int maximumSwap(int num) {
        char[] nums = Integer.toString(num).toCharArray();
        int[] buckets = new int[10];
        for (int i = 0; i < nums.length; i++) {
            buckets[nums[i] - '0'] = i;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int k = 9; k > nums[i] - '0'; k--) {
                if (buckets[k] > i) {
                    char ch = nums[i];
                    nums[i] = nums[buckets[k]];
                    nums[buckets[k]] = ch;
                    return Integer.parseInt(new String(nums));
                }
            }
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println((new Problem670()).maximumSwap(9973));
    }
}
