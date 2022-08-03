package com.mxr.demo;

public class Problem540 {
    public int singleNonDuplicate(int[] nums) {
        int from = 0, to = nums.length - 1;
        while (to > from) {
            int mid = from + (to - from) / 2;
            if (mid % 2 == 1) {
                --mid;
            }
            if (nums[mid] == nums[mid + 1]) {
                from = mid + 2;
            } else {
                to = mid;
            }
        }
        return nums[from];
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println((new Problem540()).singleNonDuplicate(nums));
    }
}
