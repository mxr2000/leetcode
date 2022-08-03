package com.mxr.demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Problem698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int allSum = Arrays.stream(nums).sum();
        if (allSum % k != 0) {
            return false;
        }
        int targetSum = allSum / k;
        Integer[] intList = new Integer[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            intList[i] = nums[i];
        }
        Arrays.sort(intList, Comparator.reverseOrder());
        return backtrack(intList, 0, k, 0, targetSum, 0, new HashMap<>());
    }

    private boolean backtrack(Integer[] nums, int from, int remains, int currentSum, int targetSum, Integer mask, HashMap<Integer, Boolean> dp) {
        int n = nums.length;
        if (remains == 1) {
            return true;
        }
        if (currentSum > targetSum) {
            return false;
        }
        if (dp.containsKey(mask)) {
            return dp.get(mask);
        }
        if (currentSum == targetSum) {
            boolean result = backtrack(nums, 0, remains - 1, 0, targetSum, mask, dp);
            dp.put(mask, result);
            return result;
        }
        for (int j = from; j < n; ++j) {
            if (((mask >> j) & 1) == 0) {
                mask = (mask | (1 << j));
                if (backtrack(nums, from + 1, remains, currentSum + nums[j], targetSum, mask, dp)) {
                    return true;
                }
                mask = (mask ^ (1 << j));
            }
        }
        dp.put(mask, false);
        return false;
    }
}
