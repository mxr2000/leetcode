package com.mxr.demo;

import java.util.*;

public class Problem994 {
    static class Point {
        public final int x; int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    public int orangesRotting(int[][] grid) {
        Set<Point> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    set.add(new Point(i, j));
                }
            }
        }
        int cnt = -1;
        while (!set.isEmpty()) {
            Set<Point> newSet = new HashSet<>();
            for (Point cur : set) {
                List<Point> surroundings = List.of(
                        new Point(cur.x - 1, cur.y),
                        new Point(cur.x + 1, cur.y),
                        new Point(cur.x, cur.y - 1),
                        new Point(cur.x, cur.y + 1)
                );
                for (Point s : surroundings) {
                    if (s.x < 0 || s.x >= grid.length || s.y < 0 || s.y >= grid[0].length) {
                        continue;
                    }
                    if (grid[s.x][s.y] == 0 || grid[s.x][s.y] == 2) {
                        continue;
                    }
                    grid[s.x][s.y] = 2;
                    newSet.add(s);
                }
            }
            set = newSet;
            cnt++;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return cnt == -1 ? 0 : cnt;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {2, 2},
                {1, 1},
                {0, 0},
                {2, 0}
        };
        System.out.println((new Problem994()).orangesRotting(grid));
    }
}
