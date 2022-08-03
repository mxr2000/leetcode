package com.mxr.demo;

public class Problem518 {
    public int change(int amount, int[] coins) {
        int[] counts = new int[amount + 1];
        counts[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                counts[i] += counts[i - coin];
            }
        }
        return counts[amount];
    }

    public static void main(String[] args) {
        System.out.println((new Problem518()).change(5, new int[]{1, 2, 5}));
    }
}
