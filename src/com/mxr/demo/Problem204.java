package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem204 {
    public int countPrimes(int n) {
        int cnt = 0;
        boolean[] notPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
                cnt++;
            }
        }

        return cnt;
    }
}
