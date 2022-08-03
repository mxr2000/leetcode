package com.mxr.demo;

public class Problem845 {
    public int longestMountain(int[] arr) {
        int beginIndex = 0;
        int largestLength = 0;
        int state = 0;
        for (int i = 1; i < arr.length; i++) {
            if (state == 0) {
                if (arr[i] <= arr[i - 1]) {
                    continue;
                } else {
                    state = 1;
                    beginIndex = i - 1;
                }
            } else if (state == 1) {
                if (arr[i] == arr[i - 1]) {
                    state = 0;
                    beginIndex = i;
                } else if (arr[i] > arr[i - 1]) {
                    continue;
                } else {
                    state = 2;
                }
            } else if (state == 2) {
                if (arr[i] == arr[i - 1]) {
                    int length = i - beginIndex;
                    if (length >= 3) {
                        largestLength = Math.max(largestLength, length);
                    }
                    state = 0;
                    beginIndex = i;
                } else if (arr[i] < arr[i - 1]) {
                    continue;
                } else {
                    int length = i - beginIndex;
                    if (length >= 3) {
                        largestLength = Math.max(largestLength, length);
                    }
                    state = 1;
                    beginIndex = i - 1;
                }
            }
        }
        if (state == 2) {
            int length = arr.length - beginIndex;
            if (length >= 3) {
                largestLength = Math.max(largestLength, length);
            }
        }
        return largestLength;
    }

    public static void main(String[] args) {
        System.out.println((new Problem845()).longestMountain(new int[]{875, 884, 239, 731, 723, 685}));
    }
}
