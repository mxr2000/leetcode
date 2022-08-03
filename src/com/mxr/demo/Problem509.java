package com.mxr.demo;

public class Problem509 {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int a = 0;
        int b = 1;
        for (int i = 1; i < n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }

        return b;
    }
}
