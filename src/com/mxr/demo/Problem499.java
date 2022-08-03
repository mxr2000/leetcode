package com.mxr.demo;

import java.util.*;

public class Problem499 {
    private final int[] dirs = {0, 1, 0, -1, 0};

    private int getDistance(int[][] maze, int[] p, int d) {
        int distance = 0;
        while (isInGrid(maze, p) && maze[p[0]][p[1]] == 0) {
            p = new int[]{p[0] + dirs[d], p[1] + dirs[d + 1]};
            ++distance;
        }
        return distance - 1;
    }

    private boolean isInGrid(int[][] maze, int[] p) {
        return p[0] >= 0 && p[0] < maze.length && p[1] >= 0 && p[1] < maze[0].length;
    }

    private String getPath(int[][][] dp, int[] to, int[] from) {
        Stack<Integer> directions = new Stack<>();
        String dict = "rdlu";
        while (to[0] != from[0] || to[1] != from[1]) {
            if (directions.isEmpty() || directions.peek() != dp[to[0]][to[1]][1]) {
                directions.push(dp[to[0]][to[1]][1]);
            }
            int d = dp[to[0]][to[1]][1];
            to[0] -= dirs[d];
            to[1] -= dirs[d + 1];
        }
        StringBuilder builder = new StringBuilder();
        while (!directions.isEmpty()) {
            builder.append(dict.charAt(directions.pop()));
        }
        return builder.toString();
    }

    private void chooseNewDirection(int[][][] dp, int[] to, int[] from, int newD) {
        int oldD = dp[to[0]][to[1]][1];
        String oldPath = getPath(dp, new int[]{to[0], to[1]}, from);
        dp[to[0]][to[1]][1] = newD;
        String newPath = getPath(dp, new int[]{to[0], to[1]}, from);
        for (int i = 0; i < Math.min(oldPath.length(), newPath.length()); i++) {
            if (oldPath.charAt(i) > newPath.charAt(i)) {
                return;
            } else if (oldPath.charAt(i) < newPath.charAt(i)) {
                dp[to[0]][to[1]][1] = oldD;
                return;
            }
        }
        if (oldPath.length() < newPath.length()) {
            dp[to[0]][to[1]][1] = newD;
        }
    }

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int[][][] dp = new int[maze.length][maze[0].length][2];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                dp[i][j] = new int[]{Integer.MAX_VALUE, -1};
            }
        }
        dp[ball[0]][ball[1]] = new int[]{0, -1};
        Queue<int[]> frontier = new LinkedList<>();
        frontier.add(ball);

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
                for (int j = 1; j <= distance; j++) {
                    int nx = p[0] + j * dirs[i], ny = p[1] + j * dirs[i + 1];
                    if (dp[p[0]][p[1]][0] + j < dp[nx][ny][0]) {
                        dp[nx][ny] = new int[]{dp[p[0]][p[1]][0] + j, i};
                        if (j == distance) {
                            frontier.add(new int[]{nx, ny});
                        }
                    } else if (dp[p[0]][p[1]][0] + j == dp[nx][ny][0]) {
                        chooseNewDirection(dp, new int[]{nx, ny}, ball, i);
                        if (j == distance) {
                            frontier.add(new int[]{nx, ny});
                        }
                    }
                }
            }
            //System.out.println(Arrays.toString(p) + " " + getPath(dp, p, ball));

        }

        return dp[hole[0]][hole[1]][0] == Integer.MAX_VALUE ? "impossible" : getPath(dp, hole, ball);
    }

    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1}
        };
       /* int[][] maze = {
                {0, 0, 0, 0, 0},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {0, 1, 0, 0, 0}
        };*/
        System.out.println((new Problem499()).findShortestWay(maze, new int[]{0, 4}, new int[]{3, 5}));
    }
}
