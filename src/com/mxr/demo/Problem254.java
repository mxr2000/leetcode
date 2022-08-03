package com.mxr.demo;

import java.util.LinkedList;
import java.util.List;

public class Problem254 {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new LinkedList<>();
        backtrack(result, new LinkedList<>(), n, 2, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> combination, int n, int from, int product) {
        if (product == n) {
            if (combination.size() > 1) {
                result.add(new LinkedList<>(combination));

            }
            return;
        }
        for (int val = from; val <= n / product; val++) {
            if (n % (product * val) == 0) {
                combination.add(val);
                backtrack(result, combination, n, val, product * val);
                combination.remove(combination.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println((new Problem254()).getFactors(37));
    }
}
