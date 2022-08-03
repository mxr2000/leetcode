package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem1926 {
    public int nearestExit(char[][] maze, int[] entrance) {
        int distance = 0;
        int[] dirs = {0, 1, 0, -1, 0};
        List<int[]> frontier = new ArrayList<>();
        frontier.add(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        while (!frontier.isEmpty()) {
            List<int[]> newFrontier = new ArrayList<>();
            for (int[] p : frontier) {
                if (p != entrance && (p[0] == 0 || p[0] == maze.length - 1 || p[1] == 0 || p[1] == maze[0].length - 1)) {
                    return distance;
                }
                for (int i = 0; i < 4; i++) {
                    int nr = p[0] + dirs[i];
                    int nc = p[1] + dirs[i + 1];
                    if (nr < 0 || nr >= maze.length || nc < 0 || nc >= maze[0].length) {
                        continue;
                    }
                    if (maze[nr][nc] == '+') {
                        continue;
                    }
                    maze[nr][nc] = '+';
                    newFrontier.add(new int[] {nr, nc});
                }
            }
            frontier = newFrontier;
            ++distance;
        }
        return -1;
    }

    public static void main(String[] args) {
        char[][] maze = {
                {'+', '+', '+'},
                {'.', '.', '.'},
                {'+', '+', '+'}
        };
        System.out.println((new Problem1926()).nearestExit(maze, new int[] {1, 0}));
    }
}
