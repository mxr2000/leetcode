package com.mxr.demo;

import java.util.LinkedList;
import java.util.Queue;

public class Problem713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int p = 1, result = 0;
        int left = 0;
        for (int right = 0; right < nums.length; ++right) {
            p *= nums[right];
            while (left < right && p >= k) {
                p /= nums[left++];
            }
            if (p < k) {
                result += (right - left + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        System.out.println((new Problem713()).numSubarrayProductLessThanK(nums, 100));
    }
}
