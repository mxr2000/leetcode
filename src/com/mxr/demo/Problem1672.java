package com.mxr.demo;

import java.util.Arrays;
import java.util.Comparator;

public class Problem1672 {
    public int maximumWealth(int[][] accounts) {
        return Arrays.stream(accounts).map(pair -> Arrays.stream(pair).sum()).max(Comparator.comparingInt(a -> a)).orElse(0);
    }
}
