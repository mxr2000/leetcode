package com.mxr.demo;

public class Problem153 {
    public int findMin(int[] nums) {
        if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        return findMin(nums, 0, nums.length - 1);
    }
    private int findMin(int[] nums, int from, int to) {
        if (from == to) {
            return nums[to];
        }
        int mid = (from + to) / 2;
        if (nums[mid] > nums[0]) {
            return findMin(nums, mid + 1, to);
        } else if (nums[mid] < nums[0]) {
            return findMin(nums, from, mid);
        } else {
            return nums[mid];
        }
    }

    public static void main(String[] args) {
        System.out.println((new Problem153()).findMin(new int[]{11, 13, 15, 17}));
    }
}
