package com.mxr.demo;

public class Problem2374 {
    public int edgeScore(int[] edges) {
        int n = edges.length, max = -1, result = 0;
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[edges[i]] += i;
            if (scores[edges[i]] > max) {
                max = scores[edges[i]];
                result = edges[i];
            } else if (scores[edges[i]] == max) {
                result = Math.min(result, edges[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] edges = {3, 3, 3, 0};
        System.out.println((new Problem2374()).edgeScore(edges));
    }
}
