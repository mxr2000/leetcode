package com.mxr.demo;

import java.util.Stack;

public class Problem376 {
    // 1,7,4,9,2,5
    // 1,2,3,4
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int[][] rise = new int[n][2];
        int[][] fall = new int[n][2];
        rise[0] = fall[0] = new int[] {nums[0], 1};
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            if (num > fall[i - 1][0]) {
                rise[i] = new int[] {num, fall[i - 1][1] + 1};
            } else {
                rise[i] = new int[] {rise[i - 1][0], rise[i - 1][1]};
            }
            if (num < rise[i - 1][0]) {
                fall[i] = new int[] {num, rise[i - 1][1] + 1};
            } else {
                fall[i] = new int[] {fall[i - 1][0], fall[i - 1][1]};
            }
        }
        return Math.max(rise[n - 1][1], fall[n - 1][1]);
    }


    public static void main(String[] args) {
        System.out.println((new Problem376()).wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}));
    }
}
