package com.mxr.demo;

import java.util.Arrays;
import java.util.Comparator;

public class Problem1024 {
    public int videoStitching(int[][] clips, int time) {
        int[] dp = new int[time + 1];
        Arrays.fill(dp, 101);
        Arrays.sort(clips, Comparator.comparingInt(p -> p[0]));
        for (int[] c : clips) {
            if (c[0] >= time + 1) {
                break;
            }
            if (c[0] != 0 && dp[c[0]] == 101) {
                return -1;
            }
            int last = c[0] == 0 ? 0 : dp[c[0]];
            for (int i = c[0]; i <= c[1] && i <= time; i++) {
                dp[i] = Math.min(dp[i], last + 1);
            }
        }
        return dp[time] == 101 ? -1 : dp[time];
    }

    public static void main(String[] args) {
        int[][] clips = {{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}};
        int time = 10;
        System.out.println((new Problem1024()).videoStitching(clips, time));
    }
}
