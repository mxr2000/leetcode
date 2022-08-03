package com.mxr.demo;

import java.util.HashSet;
import java.util.Set;

public class Problem202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            if (n == 1) {
                return true;
            }
            if (set.contains(n)) {
                return false;
            } else {
                set.add(n);
                n = calculate(n);
            }
        }
    }

    private int calculate(int num) {
        int result = 0;
        while (num > 0) {
            int n = num % 10;
            result += n * n;
            num /= 10;
        }
        return result;
    }
}
