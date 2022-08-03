package com.mxr.demo;

public class Problem2087 {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int cost = 0;
        for (int row = startPos[0]; row != homePos[0];) {
            row += (row > homePos[0] ? -1 : 1);
            cost += rowCosts[row];
        }
        for (int col = startPos[1]; col != homePos[1];) {
            col += (col > homePos[1] ? -1 : 1);
            cost += colCosts[col];
        }
        return cost;
    }
}
