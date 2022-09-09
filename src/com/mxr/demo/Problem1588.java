package com.mxr.demo;

public class Problem1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length, result = 0;
        int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + arr[i - 1];
            for (int j = i - 1; j >= 0; j -= 2) {
                result += (sums[i] - sums[j]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,2,5,3};
        System.out.println((new Problem1588()).sumOddLengthSubarrays(arr));
    }
}
