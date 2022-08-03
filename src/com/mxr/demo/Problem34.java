package com.mxr.demo;

import java.util.Arrays;

public class Problem34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] {-1, -1};
        }
        int from = 0, to = nums.length - 1, mid = (from + to) / 2;
        do {
            if (nums[mid] < target) {
                from = mid + 1;
            } else if (nums[mid] > target) {
                to = mid - 1;
            }
            mid = (from + to) / 2;
            if (from >= to) {
                break;
            }
        } while (nums[mid] != target);
        if (nums[mid] != target) {
            return new int[] {-1, -1};
        }
        int[] result = new int[2];

        int leftFrom = from, leftTo = mid - 1, leftMid = (leftFrom + leftTo) / 2;
        if (mid > from) {
            while (leftFrom != leftTo) {
                leftMid = (leftFrom + leftTo) / 2;
                if (nums[leftMid] < target) {
                    leftFrom = leftMid + 1;
                }
            }
        } else {
            leftMid = mid;
        }

        int rightFrom = mid + 1, rightTo = to, rightMid = (rightFrom + rightTo) / 2;

        if (mid < to) {
            while (rightFrom != rightTo) {
                rightMid = (rightFrom + rightTo) / 2;
                if (nums[rightMid] > target) {
                    rightTo = rightMid - 1;
                }
            }
        } else {
            rightMid = mid;
        }

        result[0] = nums[leftMid] == target ? leftMid : mid;
        result[1] = nums[rightMid] == target ? rightMid : mid;
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(Arrays.toString((new Problem34()).searchRange(nums, 1)));
    }
}
