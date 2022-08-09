package com.mxr.demo;

import java.util.Arrays;

public class Problem1151 {
    public int minSwaps(int[] data) {
        int n = data.length;
        int totalCnt = Arrays.stream(data).sum();
        int result = n;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += data[i];
            if (i < totalCnt - 1) {
                continue;
            } else if (i >= totalCnt) {
                sum -= data[i - totalCnt];
            }
            result = Math.min(result, totalCnt - sum);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data = {1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1};
        System.out.println((new Problem1151()).minSwaps(data));
    }
}
