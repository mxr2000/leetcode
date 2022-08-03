package com.mxr.demo;

public class Problem343 {
    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        }
        int num = (int) Math.sqrt(n);
        int last = n - num * (num - 1);
        int ret = 1;
        for (int i = 1; i < num; i++) {
            ret *= num;
        }
        ret *= last;
        return ret;
    }

    public static void main(String[] args) {
        System.out.println((new Problem343()).integerBreak(10));
    }
}
