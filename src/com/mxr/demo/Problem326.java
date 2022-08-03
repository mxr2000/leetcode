package com.mxr.demo;

import java.util.Arrays;
import java.util.Map;

public class Problem326 {
    public boolean isPowerOfThree(int n) {
        if (n <= 1) {
            return false;
        }
        while (n != 1) {
            if (n % 3 != 0) {
                return false;
            }
            n /= 3;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println((new Problem326()).isPowerOfThree(27));
    }
}
