package com.mxr.demo;

import java.util.*;

public class Problem286 {
    static class Point {
        int x; int y;
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
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    process(rooms, new Point(i, j));
                }
            }
        }
    }

    void process(int[][] map, Point p) {
        Set<Point> visited = new HashSet<>();
        Set<Point> set = new HashSet<>();
        set.add(p);
        int value = 0;
        while (!set.isEmpty()) {
            Set<Point> newSet = new HashSet<>();
            for (Point cur : set) {
                visited.add(cur);
                map[cur.x][cur.y] = Math.min(map[cur.x][cur.y], value);
                List<Point> surroundings = List.of(
                        new Point(cur.x - 1, cur.y),
                        new Point(cur.x + 1, cur.y),
                        new Point(cur.x, cur.y - 1),
                        new Point(cur.x, cur.y + 1)
                );
                for (Point s : surroundings) {
                    if (visited.contains(s) || s.x < 0 || s.x >= map.length || s.y < 0 || s.y >= map[0].length) {
                        continue;
                    }
                    if (map[s.x][s.y] == -1 || map[s.x][s.y] == 0 ) {
                        continue;
                    }
                    newSet.add(s);
                }
            }
            set = newSet;
            value++;
        }
    }

    public static void main(String[] args) {
        int m = 2147483647;
        int[][] map = {
                {m, -1, 0, m},
                {m, m, m, -1},
                {m, -1, m, -1},
                {0, -1, m, m}
        };
        (new Problem286()).wallsAndGates(map);
    }
}
