package com.mxr.demo;

import java.util.*;

public class Problem130 {
    static class Point {
        int x, y;
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
    public void solve(char[][] board) {
        Set<Point> closeOnes = new HashSet<>();
        Set<Point> openOnes = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                Point point = new Point(i, j);
                if (board[i][j] == 'O' && !closeOnes.contains(point) && !openOnes.contains(point)) {
                    Set<Point> path = new HashSet<>();
                    boolean isClosed = process(path, point, board);
                    if (isClosed) {
                        closeOnes.addAll(path);
                    } else {
                        openOnes.addAll(path);
                    }
                }
            }
        }
        for (Point p : closeOnes) {
            board[p.x][p.y] = 'X';
        }
    }

    private boolean process(Set<Point> visited, Point point, char[][] board) {
        int width = board[0].length;
        int height = board.length;
        if (visited.contains(point)) {
            return true;
        }
        if (point.x < 0 || point.x >= height || point.y < 0 || point.y >= width) {
            return false;
        }
        if (board[point.x][point.y] == 'X') {
            return true;
        }
        visited.add(point);
        boolean isClose = true;
        if (!process(visited, new Point(point.x, point.y + 1), board)) {
            isClose = false;
        }
        if (!process(visited, new Point(point.x, point.y - 1), board)) {
            isClose = false;
        }
        if (!process(visited, new Point(point.x + 1, point.y), board)) {
            isClose = false;
        }
        if (!process(visited, new Point(point.x - 1, point.y), board)) {
            isClose = false;
        }
        return isClose;
    }

    public static void main(String[] args) {
        char[][] map = {
                {'O', 'O', 'O', 'O', 'X', 'X'},
                {'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'O', 'O'}
        };
        (new Problem130()).solve(map);
        System.out.println(map);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
