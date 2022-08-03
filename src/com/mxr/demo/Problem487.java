package com.mxr.demo;

public class Problem487 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0, right = 0;
        boolean flipped = false;
        int result = 1;
        while (right < nums.length) {
            if (nums[right] == 0) {
                if (!flipped) {
                    flipped = true;
                } else {
                    while (left <= right && nums[left] != 0) {
                        ++left;
                    }
                    ++left;
                }
            }
            result = Math.max(result, right - left + 1);
            ++right;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1, 0};
        System.out.println((new Problem487()).findMaxConsecutiveOnes(nums));
    }
}
