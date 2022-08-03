package com.mxr.demo;

import java.util.*;

public class Problem40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int c : candidates) {
            map.put(c, 1 + map.getOrDefault(c, 0));
        }
        int[][] counts = new int[map.size()][2];
        int index = 0;
        for (int key : map.keySet()) {
            counts[index][0] = key;
            counts[index++][1] = map.get(key);
        }
        List<List<Integer>> results = new ArrayList<>();
        dfs(results, counts, new ArrayList<>(), 0, target);
        return results;
    }

    private void dfs(List<List<Integer>> results, int[][] counts, List<Integer> result, int current, int target) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            results.add(new ArrayList<>(result));
            return;
        }

        for (int next = current; next < counts.length; next++) {

            int[] entry = counts[next];
            int candidate = entry[0];
            int freq = entry[1];
            for (int i = 1; i <= freq; i++) {
                counts[next][1] = freq - i;
                result.add(candidate);
                dfs(results, counts, result, next + 1, target - i * candidate);
            }
            counts[next][1] = freq;
            for (int i = 1; i <= freq; i++) {
                result.remove(result.size() - 1);
            }

        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 5, 2, 1, 2};
        System.out.println((new Problem40()).combinationSum2(candidates, 5));
    }
}
