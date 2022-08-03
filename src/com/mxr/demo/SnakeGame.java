package com.mxr.demo;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class SnakeGame {
    private final int[][] foodPositions;
    private final int width;
    private final int height;
    private final Deque<int[]> deque = new LinkedList<>();
    private final Set<Integer> occupied = new HashSet<>();
    private int score;

    public SnakeGame(int width, int height, int[][] food) {
        this.foodPositions = food;
        this.width = width;
        this.height = height;
        deque.offerFirst(new int[] {0, 0});
        occupied.add(0);
    }

    public int move(String direction) {
        int[] dirs = {0, 1, 0, -1, 0};
        int d;
        if ("L".equals(direction)) {
            d = 2;
        } else if ("R".equals(direction)) {
            d = 0;
        } else if ("U".equals(direction)) {
            d = 3;
        } else {
            d = 1;
        }
        int[] p = deque.peekFirst();
        int nx = p[0] + dirs[d], ny = p[1] + dirs[d + 1];
        if (nx < 0 || nx >= height || ny < 0 || ny >= width) {
            return -1;
        }
        if (occupied.contains(nx * width + ny) && !(deque.peekLast()[0] == nx && deque.peekLast()[1] == ny)) {
            return -1;
        }

        if (score < foodPositions.length && nx == foodPositions[score][0] && ny == foodPositions[score][1]) {
            ++score;
        } else {
            int[] tail = deque.pollLast();
            occupied.remove(tail[0] * width + tail[1]);
        }
        deque.offerFirst(new int[] {nx, ny});
        occupied.add(nx * width + ny);

        return score;
    }

    public static void main(String[] args) {
        int[][] food = {
                {2, 0},
                {0, 0},
                {0, 2},
                {2, 2}
        };
        SnakeGame game = new SnakeGame(3, 3, food);
        System.out.println(game.move("D"));
        System.out.println(game.move("D"));
        System.out.println(game.move("R"));
        System.out.println(game.move("U"));
        System.out.println(game.move("U"));
        System.out.println(game.move("L"));
        System.out.println(game.move("D"));
        System.out.println(game.move("R"));
        System.out.println(game.move("R"));
        System.out.println(game.move("U"));
        System.out.println(game.move("L"));
        System.out.println(game.move("D"));
    }
}
