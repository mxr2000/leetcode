package com.mxr.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> points = new ArrayList<>();
        for (int[] b : buildings) {
            points.add(new int[] {b[0], b[2], 0});
            points.add(new int[] {b[1], b[2], 1});
        }
        points.sort((p1, p2) -> p1[0] != p2[0] ? p1[0] - p2[0] : p2[1] - p1[1]);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < points.size(); i++) {

        }
        return result;
    }
}
