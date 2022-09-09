package com.mxr.demo;

public class Problem27 {
    public int removeElement(int[] nums, int val) {
        int n = nums.length, result = n;
        for (int i = 0; i < n; i++) {
            if (nums[i] == val) {
                nums[i] = -1;
                --result;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] == -1) {
                continue;
            }
            if (i == 0 || nums[i - 1] != -1) {
                continue;
            }
            int j = i;
            while (j > 0 && nums[j - 1] == -1) {
                --j;
            }
            nums[j] = nums[i];
            nums[i] = -1;
        }

        return result;
    }
}
