package com.mxr.demo;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem542 {
    public int[][] updateMatrix(int[][] mat) {
        int[][] results = new int[mat.length][mat[0].length];
        Queue<Integer> indexes = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    indexes.offer(i * mat[0].length + j);
                    results[i][j] = 0;
                } else {
                    results[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int current = 0;
        while (!indexes.isEmpty()) {
            Queue<Integer> newList = new LinkedList<>();
            while (!indexes.isEmpty()) {
                int index = indexes.poll();
                int x = index / mat[0].length;
                int y = index % mat[0].length;
                if (x - 1 >= 0 && results[x - 1][y] == Integer.MAX_VALUE) {
                    results[x - 1][y] = current + 1;
                    newList.add((x - 1) * mat[0].length + y);
                }
                if (x + 1 < mat.length && results[x + 1][y] == Integer.MAX_VALUE) {
                    results[x + 1][y] = current + 1;
                    newList.add((x + 1) * mat[0].length + y);
                }
                if (y - 1 >= 0 && results[x][y - 1] == Integer.MAX_VALUE) {
                    results[x][y - 1] = current + 1;
                    newList.add(x * mat[0].length + y - 1);
                }
                if (y + 1 < mat[0].length && results[x][y + 1] == Integer.MAX_VALUE) {
                    results[x][y + 1] = current + 1;
                    newList.add(x * mat[0].length + y + 1);
                }
            }
            indexes = newList;
            current++;
        }
        return results;
    }

    public static void main(String[] args) {
        int[][] mat = {{0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 1, 0}, {1, 0, 1, 1, 1}, {1, 0, 0, 0, 1}};
        int[][] results = (new Problem542()).updateMatrix(mat);
        System.out.println(results);
    }
}
