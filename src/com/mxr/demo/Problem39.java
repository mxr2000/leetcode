package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            solve(results, new ArrayList<>(), target, candidates, i);
        }
        return results;
    }

    private void solve(List<List<Integer>> results, List<Integer> current, int target, int[] candidates, int index) {
        if (target == 0) {
            results.add(new ArrayList<>(current));
            return;
        } else if (target < 0) {
            return;
        }
        int n = candidates.length, cnt = 0;
        if (index == n) {
            return;
        }
        do {
            current.add(candidates[index]);
            target -= candidates[index];
            ++cnt;
            solve(results, current, target, candidates, index + 1);
        } while (target >= 0);
        while (cnt-- > 0) {
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] can = {2, 3, 6, 7};
        System.out.println((new Problem39()).combinationSum(can, 7));
    }
}
