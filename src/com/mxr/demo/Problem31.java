package com.mxr.demo;

public class Problem31 {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(i, j, nums);
        }
        reverse(nums, i +1);

    }
    void reverse(int[] nums, int begin) {
        int i = begin, j = nums.length - 1;
        while (i < j) {
            swap(i, j, nums);
            i++;
            j--;
        }
    }
    void swap(int i, int j, int[] nums) {
        int data = nums[i];
        nums[i] = nums[j];
        nums[j] = data;
    }
}
