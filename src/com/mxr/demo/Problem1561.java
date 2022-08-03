package com.mxr.demo;

import java.util.Arrays;

public class Problem1561 {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int sum = 0;
        for (int i = 0; i < piles.length / 3; i++) {
            int index = piles.length - 2 * i - 2;
            sum += piles[index];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] coins = {9, 8, 7, 6, 5, 1, 2, 3, 4};
        System.out.println((new Problem1561()).maxCoins(coins));
    }
}
