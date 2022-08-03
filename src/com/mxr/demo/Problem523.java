package com.mxr.demo;

import java.util.HashMap;
import java.util.Map;

public class Problem523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum %= k;
            if (map.containsKey(sum) && i - map.get(sum) >= 2) {
                return true;
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {5, 0, 0, 0};
        System.out.println((new Problem523()).checkSubarraySum(nums, 3));
    }
}
