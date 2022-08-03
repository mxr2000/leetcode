package com.mxr.demo;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem505 {
    private final int[] dirs = {0, 1, 0, -1, 0};

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][][] dp = new int[maze.length][maze[0].length][2];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                dp[i][j] = new int[]{Integer.MAX_VALUE, -1};
            }
        }
        dp[start[0]][start[1]] = new int[]{0, -1};
        Queue<int[]> frontier = new LinkedList<>();
        frontier.add(start);

        while (!frontier.isEmpty()) {
            int[] p = frontier.poll();
            for (int i = 0; i < 4; i++) {
                if (dp[p[0]][p[1]][1] != -1 && i == (dp[p[0]][p[1]][1] + 2) % 4) {
                    continue;
                }
                int distance = getDistance(maze, p, i);
                if (distance == 0) {
                    continue;
                }
                int[] np = getNextPosition(p, i, distance);
                if (dp[np[0]][np[1]][0] > dp[p[0]][p[1]][0] + distance) {
                    dp[np[0]][np[1]] = new int[]{dp[p[0]][p[1]][0] + distance, i};
                    frontier.add(np);
                }
            }
        }
        return dp[destination[0]][destination[1]][0] == Integer.MAX_VALUE ? -1 : dp[destination[0]][destination[1]][0];
    }

    private int getDistance(int[][] maze, int[] p, int d) {
        int distance = 0;
        while (isInGrid(maze, p) && maze[p[0]][p[1]] == 0) {
            p = new int[]{p[0] + dirs[d], p[1] + dirs[d + 1]};
            ++distance;
        }
        return distance - 1;
    }

    private int[] getNextPosition(int[] p, int d, int distance) {
        return new int[]{p[0] + distance * dirs[d], p[1] + distance * dirs[d + 1]};
    }

    private boolean isInGrid(int[][] maze, int[] p) {
        return p[0] >= 0 && p[0] < maze.length && p[1] >= 0 && p[1] < maze[0].length;
    }

    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        System.out.println((new Problem505()).shortestDistance(maze, new int[]{1, 1}, new int[]{1, 2}));
    }
}
