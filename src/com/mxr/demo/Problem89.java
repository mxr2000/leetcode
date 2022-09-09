package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem89 {
    public List<Integer> grayCode(int n) {
        List<Integer> results = new ArrayList<>();
        results.add(0);
        for (int i = 0; i < n; i++) {
            int size = results.size();
            for (int k = size - 1; k >= 0; k--) {
                results.add(results.get(k) | 1 << i);
            }
        }
        return results;
    }

}
