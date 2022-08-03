package com.mxr.demo;

import java.util.*;

public class Problem1345 {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> equalPositions = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (!equalPositions.containsKey(arr[i])) {
                equalPositions.put(arr[i], new ArrayList<>());
            }
            equalPositions.get(arr[i]).add(i);
        }
        boolean[] visited = new boolean[n];
        visited[0] = true;
        List<Integer> frontier = new ArrayList<>();
        int result = 0;
        frontier.add(0);
        while (!frontier.isEmpty()) {
            List<Integer> newFrontier = new ArrayList<>();
            for (int p : frontier) {
                if (p == n - 1) {
                    return result;
                }
                if (p > 0 && !visited[p - 1]) {
                    visited[p - 1] = true;
                    newFrontier.add(p - 1);
                }
                if (p < n - 1 && !visited[p + 1]) {
                    visited[p + 1] = true;
                    newFrontier.add(p + 1);
                }
                for (int newP : equalPositions.get(arr[p])) {
                    if (!visited[newP]) {
                        visited[newP] = true;
                        newFrontier.add(newP);
                    }
                }
                equalPositions.get(arr[p]).clear();
            }
            ++result;
            frontier = newFrontier;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {7,6,9,6,9,6,9,7};
        System.out.println((new Problem1345()).minJumps(arr));
    }
}
