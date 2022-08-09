package com.mxr.demo;

public class Problem977 {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int left = 0, right = n - 1;
        for (int i = 0; i < n; i++) {
            int num;
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                num = nums[left++];
            } else {
                num = nums[right--];
            }
            result[n - i - 1] = num * num;
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
