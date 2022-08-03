package com.mxr.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem1636 {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Arrays.stream(nums).forEach(num -> frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1));
        return Arrays.stream(nums)
                .boxed()
                .sorted((a, b) -> frequencyMap.get(a) != frequencyMap.get(b) ? frequencyMap.get(a) - frequencyMap.get(b) : b - a)
                .mapToInt(n -> n)
                .toArray();
    }
}
