package com.mxr.demo;

import java.util.*;

public class Problem1557 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(i);
        }
        for (List<Integer> edge : edges) {
            int to = edge.get(1);
            set.remove(to);
        }
        return set.stream().toList();
    }

    public static void main(String[] args) {
        
    }
}
