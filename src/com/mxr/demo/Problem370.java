package com.mxr.demo;

public class Problem370 {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        for (int[] u : updates) {
            for (int i = u[0]; i <= u[1]; i++) {
                result[i] += u[2];
            }
        }
        return result;
    }
}
