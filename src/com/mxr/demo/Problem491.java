package com.mxr.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(results, new ArrayList<>(), nums, 0);
        return results;
    }

    private void backtrack(List<List<Integer>> results, List<Integer> current, int[] nums, int index) {
        if (current.size() >= 2) {
            results.add(new ArrayList<>(current));
        }
        Set<Integer> used = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (used.contains(nums[i])) {
                continue;
            }
            if (current.isEmpty() || nums[i] >= current.get(current.size() - 1)) {
                used.add(nums[i]);
                current.add(nums[i]);
                backtrack(results, current, nums, i + 1);
                current.remove(current.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 6, 7, 7};
        System.out.println((new Problem491()).findSubsequences(nums));
    }
}
