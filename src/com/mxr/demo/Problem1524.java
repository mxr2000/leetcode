package com.mxr.demo;

public class Problem1524 {
    public int numOfSubarrays(int[] arr) {
        int oddCnt = 0, result = 0;
        int left = 0, right = 0, n = arr.length;
        for (; right < n; ++right) {
            oddCnt += arr[right] % 2 == 0 ? 0 : 1;

            if (oddCnt > 0) {

            }
        }
        return 0;
    }
}
