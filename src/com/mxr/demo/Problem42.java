package com.mxr.demo;

public class Problem42 {
    public int trap(int[] height) {
        int last = 0;
        int n = height.length;
        int result = 0, curSum = 0;
        for (int i = 1; i < n; i++) {
            if (height[i] < height[last]) {
                curSum += (height[last] - height[i]);
            } else {
                result += curSum;
                last = i;
                curSum = 0;
            }
        }
        int rLast = n - 1;
        curSum = 0;
        for (int i = n - 1; i >= last; i--) {
            if (height[i] < height[rLast]) {
                curSum += (height[rLast] - height[i]);
            } else {
                result += curSum;
                rLast = i;
                curSum = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        System.out.println((new Problem42()).trap(height));
    }
}
