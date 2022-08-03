package com.mxr.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1334 {
    /*static class Edge {
        public final int target;
        public final int weight;

        public Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] data = new int[distanceThreshold + 1][n];
        List<Edge>[] nodeEdges = new List[n];
        for (int i = 0; i < n; i++) {
            nodeEdges[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int p0 = edge[0];
            int p1 = edge[1];
            int weight = edge[2];
            nodeEdges[p0].add(new Edge(p1, weight));
            nodeEdges[p1].add(new Edge(p0, weight));
        }
        for (int threshold = 1; threshold <= distanceThreshold; threshold++) {
            if (threshold == 2) {
                System.out.println();
            }
            for (int i = 0; i < n; i++) {
                for (Edge edge : nodeEdges[i]) {
                    if (edge.weight > threshold) {
                        continue;
                    }
                    if (data[threshold - edge.weight][edge.target] + 1 > data[threshold][i]) {
                        data[threshold][i] = data[threshold - edge.weight][edge.target] + 1;
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < n; i++) {
            System.out.println(data[distanceThreshold][i]);
            if (data[distanceThreshold][i] <= min) {
                min = data[distanceThreshold][i];
                index = i;
            }
        }
        System.out.println();
        return index;
    }*/
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] data = new int[n][n];
        for (int[] array : data) {
            Arrays.fill(array, 10001);
        }
        for (int[] edge : edges) {
            int p0 = edge[0];
            int p1 = edge[1];
            int distance = edge[2];
            data[p0][p1] = data[p1][p0] = distance;
        }
        for (int i = 0; i < n; i++) {
            data[i][i] = 0;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    data[i][j] = Math.min(data[i][j], data[i][k] + data[k][j]);
                }
            }
        }
        int index = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (data[i][j] <= distanceThreshold) {
                    cnt++;
                }
            }
            if (cnt <= min) {
                min = cnt;
                index = i;
            }

        }

        return index;
    }

    public static void main(String[] args) {
        int[][] edges = {
                {0, 1, 2},
                {0, 4, 8},
                {1, 2, 3},
                {1, 4, 2},
                {2, 3, 1},
                {3, 4, 1}
        };
        System.out.println((new Problem1334()).findTheCity(5, edges, 2));
    }
}
