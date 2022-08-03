package com.mxr.demo;

public class Problem896 {
    public boolean isMonotonic(int[] nums) {
        boolean ok = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                ok = false;
                break;
            }
        }
        if (ok) {
            return true;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
