package com.mxr.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums1).forEach(n1 ->
                Arrays.stream(nums2).forEach(n2 -> {
                    map.compute(n1 + n2, (k, cnt) -> cnt == null ? 1 : ++cnt);
                })
        );

        return Arrays.stream(nums3).map(n3 ->
                Arrays.stream(nums4).map(n4 -> map.getOrDefault(-n3 - n4, 0)).sum()
        ).sum();
    }
}
