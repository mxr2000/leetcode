package com.mxr.demo;

public class Problem55 {
    public boolean canJump(int[] nums) {
        int n = nums.length, end = 0;
        int cur = 0;
        while (cur <= end) {
            if (cur == n - 1) {
                return true;
            }
            end = Math.max(end, cur + nums[cur]);
            ++cur;
        }
        return false;
    }
}
