package com.mxr.demo;

public class Problem35 {
    public int searchInsert(int[] nums, int target) {
        return search(nums, 0, nums.length, target);
    }
    int search(int[] nums, int from, int to, int target) {
        if (target < nums[from]) {
            return from;
        }
        if (to <= from) {
            return from + 1;
        } else if (to == from + 1) {
            if (target == nums[from]) {
                return from;
            } else {
                return from + 1;
            }
        }
        int mid = (from + to) / 2;
        if (target < nums[mid]) {
            return search(nums, from, mid, target);
        } else if (target > nums[mid]) {
            return search(nums, mid, to, target);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        System.out.println((new Problem35()).searchInsert(new int[]{1, 3, 5, 6}, 0));
    }
}
