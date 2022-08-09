package com.mxr.demo;

import java.util.HashMap;
import java.util.Map;

public class Problem873 {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> indexes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexes.put(arr[i], i);
        }
        Map<Integer, Integer> longest = new HashMap<>();
        int result = 0;
        for (int k = 0; k < n; k++) {
            for (int j = 0; j < k; j++) {
                int i = indexes.getOrDefault(arr[k] - arr[j], -1);
                if (i >= 0 && i < j) {
                    int candidate = longest.getOrDefault(i * n + j, 2) + 1;
                    longest.put(j * n + k, candidate);
                    result = Math.max(result, candidate);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,7,11,12,14,18};
        System.out.println((new Problem873()).lenLongestFibSubseq(arr));
    }
}
