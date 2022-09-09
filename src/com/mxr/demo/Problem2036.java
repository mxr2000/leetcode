package com.mxr.demo;

public class Problem2036 {
    public long maximumAlternatingSubarraySum(int[] nums) {
        long result = Integer.MIN_VALUE;
        int n = nums.length;
        long sum = 0;
        for (int i = 0; i < n; i += 2) {
            sum += nums[i];
            long nextSum = sum - (i == n - 1 ? 0 : nums[i + 1]);
            result = Math.max(result, Math.max(sum, nextSum));
            sum = nextSum;
            if (sum < 0) {
                sum = 0;
            }
        }
        sum = 0;
        for (int i = 1; i < n; i += 2) {
            sum += nums[i];
            long nextSum = sum - (i == n - 1 ? 0 : nums[i + 1]);
            result = Math.max(result, Math.max(sum, nextSum));
            sum = nextSum;
            if (sum < 0) {
                sum = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, -1, -1, -1};
        System.out.println((new Problem2036()).maximumAlternatingSubarraySum(nums));
    }
}
