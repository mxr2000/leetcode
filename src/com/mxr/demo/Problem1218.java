package com.mxr.demo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Problem1218 {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            int val = -1;
            if (!map.containsKey(num - difference)) {
                map.put(num, 1);
                continue;
            } else if (map.containsKey(num) && map.get(num) < map.get(num - difference) + 1) {
                val = map.get(num - difference);
                map.remove(num);
            }
            map.put(num, (val == -1 ? map.get(num - difference) : val) + 1);
        }

        return map.values().stream().max(Comparator.comparingInt(a -> a)).get();
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 8, 5, 3, 4, 2, 1};
        System.out.println((new Problem1218()).longestSubsequence(arr, -2));
    }
}
