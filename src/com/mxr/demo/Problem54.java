package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int direction = 0;
        int x = 0, y = 0;
        int[][] directions = {
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };
        while (inBound(matrix, x, y) && matrix[x][y] != Integer.MAX_VALUE) {
            result.add(matrix[x][y]);
            matrix[x][y] = Integer.MAX_VALUE;
            int nx = x + directions[direction][0];
            int ny = y + directions[direction][1];
            if (!inBound(matrix, nx, ny) || matrix[nx][ny] == Integer.MAX_VALUE) {
                direction = (direction + 1) % 4;
                nx = x + directions[direction][0];
                ny = y + directions[direction][1];
            }
            x = nx;
            y = ny;
        }
        return result;
    }

    private boolean inBound(int[][] matrix, int x, int y) {
        return x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1}
        };
        System.out.println((new Problem54()).spiralOrder(matrix));
    }
}
