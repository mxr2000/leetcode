package com.mxr.demo;

public class Problem974 {
    public int subarraysDivByK(int[] nums, int k) {
        int[] counts = new int[k];
        counts[0] = 1;
        int result = 0, sum = 0;
        int base = k * (10000 / k) + k;
        for (int num : nums) {
            sum += num;
            sum = (sum + base) % k;
            result += counts[sum];
            ++counts[sum];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 0, -2, -3, 1};
        System.out.println((new Problem974()).subarraysDivByK(nums, 5));
    }
}
