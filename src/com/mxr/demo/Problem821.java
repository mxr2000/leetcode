package com.mxr.demo;

import java.util.Arrays;

public class Problem821 {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] result = new int[n];
        Arrays.fill(result, 10000);
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != c) {
                continue;
            }
            result[i] = 0;
            for (int j = i - 1; j >= 0; --j) {
                if (s.charAt(j) != c && result[j] > (i - j)) {
                    result[j] = i - j;
                } else {
                    break;
                }
            }
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(j) != c && result[j] > (j - i)) {
                    result[j] = j - i;
                } else {
                    break;
                }
            }
        }

        return result;
    }
}
