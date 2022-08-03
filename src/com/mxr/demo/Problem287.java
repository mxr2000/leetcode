package com.mxr.demo;

public class Problem287 {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 == nums[i]) {
                continue;
            }
            int next = nums[i] - 1;
            do {
                if (nums[next] == next + 1) {
                    return next + 1;
                }
                int newNext = nums[next] - 1;
                nums[next] = next + 1;
                next = newNext;
            } while (next != i);
            nums[next] = i + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 2, 4};
        System.out.println((new Problem287()).findDuplicate(nums));
    }
}
