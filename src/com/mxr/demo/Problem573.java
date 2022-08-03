package com.mxr.demo;

public class Problem573 {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int result = 0;
        int maxGap = Integer.MIN_VALUE;
        for (int i = 0; i < nuts.length; i++) {
            int distanceToSquirrel = Math.abs(squirrel[0] - nuts[i][0]) + Math.abs(squirrel[1] - nuts[i][1]);
            int distanceToTree = Math.abs(tree[0] - nuts[i][0]) + Math.abs(tree[1] - nuts[i][1]);
            int gap = distanceToTree - distanceToSquirrel;
            if (gap > maxGap) {
                maxGap = gap;
            }
            result += 2 * distanceToTree;
        }
        return result - maxGap;
    }
}
