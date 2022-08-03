package com.mxr.demo;

public class Problem334 {
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE, large = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= small) {
                small = num;
            } else if (num <= large) {
                large = num;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {20, 100, 10, 12, 5, 13};
        System.out.println((new Problem334()).increasingTriplet(nums));
    }
}
