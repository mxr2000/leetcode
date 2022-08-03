package com.mxr.demo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new LinkedList<>(), k, n);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> combination, int k, int n) {
        int size = combination.size();
        if (size == k - 1) {
            if (n <= 9 && n > (combination.isEmpty() ? 0 : combination.get(size - 1))) {
                combination.add(n);
                result.add(new LinkedList<>(combination));
                combination.remove(size);
            }
            return;
        }
        for (int i = size == 0 ? 1 : (combination.get(size - 1) + 1); i <= 9; i++) {
            combination.add(i);
            backtrack(result, combination, k, n - i);
            combination.remove(size);
        }
    }

    public static void main(String[] args) {
        System.out.println((new Problem216()).combinationSum3(3, 9));
    }
}
