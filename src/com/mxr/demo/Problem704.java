package com.mxr.demo;

public class Problem704 {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length);
    }

    private int search(int[] nums, int target, int from, int to) {
        if (to <= from) {
            return -1;
        }
        int index = (from + to) / 2;
        if (nums[index] == target) {
            return index;
        }
        if (target > nums[index]) {
            return search(nums, target, index + 1, to);
        } else {
            return search(nums, target, from, index);
        }
    }

    public static void main(String[] args) {
        System.out.println((new Problem704()).search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }
}
