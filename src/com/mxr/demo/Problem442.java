package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int[] counts = new int[nums.length];
        for (int num : nums) {
            counts[num]++;
            if (counts[num] == 2) {
                result.add(num);
            }
        }
        return result;
    }
}
