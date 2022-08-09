package com.mxr.demo;

public class Problem926 {
    public int minFlipsMonoIncr(String s) {
        int resultZero = 0, resultOne = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '0') {
                resultOne = Math.min(resultOne, resultZero) + 1;
            } else {
                resultOne = Math.min(resultOne, resultZero);
                ++resultZero;
            }
        }
        return Math.min(resultOne, resultZero);
    }

    public static void main(String[] args) {
        System.out.println((new Problem926()).minFlipsMonoIncr("00011000"));
    }
}
