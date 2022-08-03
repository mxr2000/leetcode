package com.mxr.demo;

public class Problem485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int current = 0;
        for (int num : nums) {
            if (num == 0) {
                max = Math.max(max, current);
                current = 0;
            } else {
                current++;
            }
        }
        max = Math.max(max, current);
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println((new Problem485()).findMaxConsecutiveOnes(nums));
    }
}
