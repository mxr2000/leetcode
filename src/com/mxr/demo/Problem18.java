package com.mxr.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    public List<List<Integer>> kSum(int[] nums, long target, int from, int k) {
        List<List<Integer>> results = new ArrayList<>();
        if (from == nums.length) {
            return results;
        }

        long average = target / k;

        if (nums[from] > average || average > nums[nums.length - 1]) {
            return results;
        }

        if (k == 2) {
            return twoSum(nums, target, from);
        }

        for (int i = from; i < nums.length; i++) {
            if (i == from || nums[i - 1] != nums[i]) {
                for (List<Integer> subset : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    results.add(new ArrayList<>(Arrays.asList(nums[i])));
                    results.get(results.size() - 1).addAll(subset);
                }
            }
        }

        return results;
    }

    public List<List<Integer>> twoSum(int[] nums, long target, int from) {
        List<List<Integer>> results = new ArrayList<>();
        int low = from;
        int high = nums.length - 1;
        while (low < high) {
            if (nums[low] + nums[high] == target) {
                results.add(new ArrayList<>(Arrays.asList(nums[low], nums[high])));
                while (low < high && nums[low + 1] == nums[low]) {
                    ++low;
                }
                while (high > low && nums[high - 1] == nums[high]) {
                    --high;
                }
                --high;
                ++low;
            } else if (nums[low] + nums[high] > target) {
                --high;
            } else {
                ++low;
            }

        }

        return results;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        System.out.println((new Problem18()).fourSum(nums, 0));
    }
}
