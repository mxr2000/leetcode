package com.mxr.demo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Problem490 {
    static class Point {
        int x, y;

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

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        return dfs(maze, new HashSet<>(), new Point(start[0], start[1]), new Point(destination[0], destination[1]));
    }
    private boolean dfs(int[][] map, Set<Point> visited, Point from, Point dest) {
        if (from.equals(dest)) {
            return true;
        }
        visited.add(from);
        for (int i = 0; i < 4; i++) {
            Point to = getNextPosition(map, from, i);
            if (visited.contains(to)) {
                continue;
            }
            if (dfs(map, visited, to, dest)) {
                return true;
            }
        }
        return false;
    }
    private Point getNextPosition(int[][] map, Point from, int dir) {
        if (dir == 0) {
            int y = from.y;
            while (y + 1 <= map[0].length - 1 && map[from.x][y + 1] != 1) {
                y++;
            }
            return new Point(from.x, y);
        }
        if (dir == 1) {
            int x = from.x;
            while (x + 1 <= map.length - 1 && map[x + 1][from.y] != 1) {
                x++;
            }
            return new Point(x, from.y);
        }
        if (dir == 2) {
            int y = from.y;
            while (y - 1 >= 0 && map[from.x][y - 1] != 1) {
                y--;
            }
            return new Point(from.x, y);
        }
        if (dir == 3) {
            int x = from.x;
            while (x - 1 >= 0 && map[x - 1][from.y] != 1) {
                x--;
            }
            return new Point(x, from.y);
        }
        return null;
    }

    public static void main(String[] args) {
        int[][] map = {
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,1,0,0,0}
        };
        System.out.println((new Problem490()).hasPath(map, new int[]{0, 4}, new int[]{4, 4}));
    }

}
