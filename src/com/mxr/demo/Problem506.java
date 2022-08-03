package com.mxr.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem506 {
    public String[] findRelativeRanks(int[] score) {
        String[] results = new String[score.length];
        List<Integer> list = Arrays.stream(score).boxed().toList();
        List<Integer> sorted = list.stream().sorted(Collections.reverseOrder()).toList();
        int place = 0;
        for (int v :
                sorted) {
            int index = list.indexOf(v);
            results[index] = getExpression(place++);
        }
        return results;
    }

    private String getExpression(int index) {
        if (index == 0) {
            return "Gold Medal";
        } else if (index == 1) {
            return "Silver Medal";
        } else if (index == 2) {
            return "Bronze Medal";
        }
        return "" + (index + 1);
    }

    public static void main(String[] args) {
        int[] score = {10,3,8,9,4};
        System.out.println(Arrays.toString((new Problem506()).findRelativeRanks(score)));
    }
}
