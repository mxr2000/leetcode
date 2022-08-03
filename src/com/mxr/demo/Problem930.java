package com.mxr.demo;

public class Problem930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0, result = 0, n = nums.length;
        int[] counts = new int[n + 1];
        counts[0] = 1;
        for (int num : nums) {
            sum += num;
            if (sum >= goal) {
                result += counts[sum - goal];
            }
            ++counts[sum];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0, 0};
        System.out.println((new Problem930()).numSubarraysWithSum(nums, 0));
    }
}
