package com.mxr.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1992 {
    public int[][] findFarmland(int[][] land) {
        List<int[]> infos = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1) {
                    int[] ret = searchAndFill(land, i, j);
                    infos.add(new int[]{i, j, i + ret[0] - 1, j + ret[1] - 1});
                }
            }
        }
        int[][] results = new int[infos.size()][4];
        for (int i = 0; i < infos.size(); i++) {
            results[i] = infos.get(i);
        }
        return results;
    }


    private int[] searchAndFill(int[][] land, int cx, int cy) {
        int width = 0;
        int height = 0;
        int x = cx;
        int y = cy;

        while (x < land.length) {
            if (land[x][cy] == 1) {
                height++;
            } else {
                break;
            }
            x++;
        }
        while (y < land[0].length) {
            if (land[cx][y] == 1) {
                width++;
            } else {
                break;
            }
            y++;
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                land[cx + i][cy + j] = -1;
            }
        }

        return new int[]{height, width};
    }

    public static void main(String[] args) {
        int[][] land = {
                {1, 1, 0, 0, 0, 1},
                {1, 1, 0, 0, 0, 0}
        };
        System.out.println(Arrays.deepToString((new Problem1992()).findFarmland(land)));
    }
}
