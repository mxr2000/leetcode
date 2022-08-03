package com.mxr.demo;

import java.util.Arrays;

public class Problem643 {
    public double findMaxAverage(int[] nums, int k) {
        double result = -10001;
        int sum = Arrays.stream(nums).limit(k).sum();
        int i = 0, n = nums.length;
        while (i <= n - k) {
            result = Math.max(result, sum * 1.0 / k);
            while (i != n - k && nums[i + k] < nums[i]) {
                sum -= nums[i];
                sum += nums[i + k];
                ++i;
            }
            if (i != n - k) {
                sum -= nums[i];
                sum += nums[i + k];
                ++i;
            } else {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1};
        System.out.println((new Problem643()).findMaxAverage(nums, 1));
    }
}
