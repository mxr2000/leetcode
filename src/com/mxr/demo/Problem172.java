package com.mxr.demo;

public class Problem172 {
    public int trailingZeroes(int n) {
        int numOf2 = 0;
        int numOf5 = 0;
        int current2 = 2;
        int current5 = 5;
        while (current2 <= n) {
            numOf2 += n / current2;
            current2 *= 2;
        }
        while (current5 <= n) {
            numOf5 += n / current5;
            current5 *= 5;
        }
        return Math.min(numOf2, numOf5);
    }
}
