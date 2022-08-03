package com.mxr.demo;

import java.util.*;

public class Problem1004 {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int result = 0;
        for (; right < nums.length; right++) {
            if (nums[right] == 1) {
                result = Math.max(result, right - left + 1);
                continue;
            }
            --k;
            if (k >= 0) {
                result = Math.max(result, right - left + 1);
            } else {
                while (k < 0 && left <= right) {
                    if (nums[left] == 0) {
                        ++k;
                    }
                    ++left;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 0, 0};
        System.out.println((new Problem1004()).longestOnes(nums, 0));
    }
}
