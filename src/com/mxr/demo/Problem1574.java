package com.mxr.demo;

public class Problem1574 {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length, result = n;
        int left = 0, right = n - 1;
        while (left + 1 < n && arr[left] <= arr[left + 1]) {
            ++left;
        }
        if (left == n - 1) {
            return 0;
        }
        while (right > left && arr[right - 1] <= arr[right]) {
            --right;
        }
        result = Math.min(n - left - 1, right);
        int i = 0, j = right;
        while (i <= left && j < n) {
            if (arr[j] >= arr[i]) {
                result = Math.min(result, j - i - 1);
                ++i;
            } else {
                ++j;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println((new Problem1574()).findLengthOfShortestSubarray(arr));
    }
}
