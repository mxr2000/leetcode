package com.mxr.demo;

import java.util.Arrays;

public class Problem322 {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] counts = new int[amount + 1];
        counts[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && counts[i - coin] != -1) {
                    min = Math.min(min, 1 + counts[i - coin]);
                }
            }
            if (min == Integer.MAX_VALUE) {
                counts[i] = -1;
            } else {
                counts[i] = min;
            }
        }

        return counts[amount];
    }

    public static void main(String[] args) {
        System.out.println((new Problem322()).coinChange(new int[]{1, 2, 5}, 11));
    }
}
