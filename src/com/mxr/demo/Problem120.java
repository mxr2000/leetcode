package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        List<List<Integer>> costs = new ArrayList<>();
        costs.add(List.of(triangle.get(0).get(0)));
        for (int i = 1; i < triangle.size(); i++) {
            costs.add(new ArrayList<>());
            for (int j = 0; j <= i; j++) {
                int min;
                if (j == 0) {
                    min = costs.get(i - 1).get(0);
                } else if (j == i) {
                    min = costs.get(i - 1).get(i - 1);
                } else {
                    min = Math.min(costs.get(i - 1).get(j - 1), costs.get(i - 1).get(j));
                }
                costs.get(i).add(min + triangle.get(i).get(j));
            }
        }
        int min = Integer.MAX_VALUE;
        for (int num : costs.get(costs.size() - 1)) {
            min = Math.min(min, num);
        }
        return min;
    }

    public static void main(String[] args) {

        List<List<Integer>> input = List.of(
                List.of(2),
                List.of(3, 4),
                List.of(6, 5, 7),
                List.of(4, 1, 8, 3)
        );
        System.out.println((new Problem120()).minimumTotal(input));
    }
}
