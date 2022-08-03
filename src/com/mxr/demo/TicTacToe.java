package com.mxr.demo;

public class TicTacToe {
    private final int[][] grid;
    private final int n;
    public TicTacToe(int n) {
        this.n = n;
        this.grid = new int[n][n];
    }

    public int move(int row, int col, int player) {
        grid[row][col] = player;
        return (checkHorizontal(row, player) || checkVertical(col, player)) || checkDiagonal(player) || checkCounterDiagonal(player) ? player : 0;
    }

    private boolean checkHorizontal(int x, int p) {
        for (int y = 0; y < n; y++) {
            if (grid[x][y] != p) {
                return false;
            }
        }
        return true;
    }

    private boolean checkVertical(int y, int p) {
        for (int x = 0; x < n; x++) {
            if (grid[x][y] != p) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonal(int p) {
        for (int i = 0; i < n; i++) {
            if (grid[i][i] != p) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCounterDiagonal(int p) {
        for (int i = 0; i < n; i++) {
            if (grid[i][n - i - 1] != p) {
                return false;
            }
        }
        return true;
    }
}
