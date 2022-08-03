package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List result;
            if (i == 0) {
                result = List.of(1);
            } else {
                result = new ArrayList();
                result.add(1);
                for (int j = 0; j < i - 1; j++) {
                    result.add(results.get(i - 1).get(j) + results.get(i - 1).get(j + 1));
                }
                result.add(1);
            }
            results.add(result);
        }
        return results;
    }
}
