package com.mxr.demo;

import java.util.Arrays;
import java.util.Comparator;

public class Problem2271 {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        int fromIndex = 0;
        int cover = 0;
        int max = 0;
        Arrays.sort(tiles, Comparator.comparingInt(t -> t[0]));
        for (int i = 0; max < carpetLen && fromIndex < tiles.length && i < tiles.length; ) {
            if (tiles[fromIndex][0] + carpetLen > tiles[i][1]) {
                cover += (tiles[i][1] - tiles[i][0] + 1);
                max = Math.max(max, cover);
                i++;
            } else {
                int partial = Math.max(0, tiles[fromIndex][0] + carpetLen - tiles[i][0]);
                max = Math.max(max, cover + partial);
                cover -= (tiles[fromIndex][1] - tiles[fromIndex][0] + 1);
                fromIndex += 1;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] tiles = {
                {10, 11},
                {1, 1}
        };
        System.out.println((new Problem2271()).maximumWhiteTiles(tiles, 10));
    }
}
