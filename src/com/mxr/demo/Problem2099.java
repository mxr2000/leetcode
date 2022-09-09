package com.mxr.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem2099 {
    public int[] maxSubsequence(int[] nums, int k) {
        List<int[]> arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            arr.add(new int[] {nums[i], i});
        }
        return arr.stream()
                .sorted(Comparator.comparingInt(p -> p[0]))
                .limit(k)
                .sorted(Comparator.comparingInt(p -> p[1]))
                .map(p -> p[0])
                .mapToInt(a -> a)
                .toArray();
    }
}
