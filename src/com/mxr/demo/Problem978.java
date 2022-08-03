package com.mxr.demo;

public class Problem978 {
    public int maxTurbulenceSize(int[] arr) {
        int left = 0, right = 0;
        int result = 0;
        while (right < arr.length) {
            if (right >= 1 && arr[right] == arr[right - 1]) {
                left = right;
            } else if (right >= 2 && Integer.compare(arr[right] - arr[right - 1], 0) * Integer.compare(arr[right - 1] - arr[right - 2], 0) >= 0) {
                left = right - 1;
            }
            result = Math.max(result, right - left + 1);
            ++right;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {9,4,2,10,7,8,8,1,9};
        System.out.println((new Problem978()).maxTurbulenceSize(nums));
    }
}
