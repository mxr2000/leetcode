package com.mxr.demo;

public class Problem376 {
    // 1,7,4,9,2,5
    // 1,2,3,4
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int begin = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            begin = i;
            break;
        }
        if (begin == -1) {
            return 1;
        }
        boolean shouldIncrease = nums[begin] > nums[begin + 1];
        int cnt = 2;
        int last = nums[begin + 1];
        for (int i = begin + 2; i < nums.length; i++) {
            if (shouldIncrease && nums[i] > last) {
                cnt++;
                last = nums[i];
                shouldIncrease = false;
            } else if (!shouldIncrease && nums[i] < last) {
                cnt++;
                last = nums[i];
                shouldIncrease = true;
            }
        }
        return cnt;
    }
    private int maxLength(int[] nums, int begin, int last, boolean shouldIncrease) {
        int max = 0;
        for (int i = begin; i < nums.length; i++) {
            if (shouldIncrease && nums[i] > last) {
                max = Math.max(max, 1 + maxLength(nums, i + 1, nums[i], false));
            } else if (!shouldIncrease && nums[i] < last) {
                max = Math.max(max, 1 + maxLength(nums, i + 1, nums[i], true));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println((new Problem376()).wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}));
    }
}
