package com.mxr.demo;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem378 {
    public int kthSmallest(int[][] matrix, int k) {
        int min = -1000000001;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p[0]));
        pq.add(new int[] {matrix[0][0], 0, 0});
        matrix[0][0] = min;
        while (!pq.isEmpty() && k > 1) {
            int[] p = pq.poll();
            int x = p[1], y = p[2];
            if (x != matrix.length - 1 && matrix[x + 1][y] != min) {
                pq.offer(new int[] {matrix[x + 1][y], x + 1, y});
                matrix[x + 1][y] = min;
            }
            if (y != matrix[0].length - 1 && matrix[x][y + 1] != min) {
                pq.offer(new int[] {matrix[x][y + 1], x, y + 1});
                matrix[x][y + 1] = min;
            }
            --k;
        }
        return pq.isEmpty() ? 0 : pq.poll()[0];
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5},
                {6, 7, 12},
                {11, 14, 14}
        };
        System.out.println((new Problem378()).kthSmallest(matrix, 6));
    }
}
