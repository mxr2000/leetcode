package com.mxr.demo;

public class Problem70 {
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int oneStepBefore = 2;
        int twoStepBefore = 1;
        int allWays = 0;
        for (int i = 2; i < n; i++) {
            allWays = oneStepBefore + twoStepBefore;
            twoStepBefore = oneStepBefore;
            oneStepBefore = allWays;
        }
        return allWays;
    }

    public static void main(String[] args) {
        System.out.println((new Problem70()).climbStairs(4));
    }
}

// 1 1 1 1
// 2 1 1
// 1 2 1
// 1 1 2
// 2 2
