package com.mxr.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem229 {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);

        }
        map.forEach((key, val) -> {
            if (key > nums.length / 3) {
                result.add(val);
            }
        });

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        System.out.println((new Problem229()).majorityElement(nums));
    }
}
