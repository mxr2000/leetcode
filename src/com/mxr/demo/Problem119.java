package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> current = new ArrayList<>();
        current.add(1);
        for (int i = 0; i < rowIndex; i++) {
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            for (int j = 0; j < current.size() - 1; j++) {
                newRow.add(current.get(j) + current.get(j + 1));
            }
            newRow.add(1);
            current = newRow;
        }
        return current;
    }
}
