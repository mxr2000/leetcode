package com.mxr.demo;

public class Problem11 {
    public int maxArea(int[] height) {
        int n = height.length, left = 0, right = n - 1, result = 0;
        while (left < right) {
            int val = (right - left) * Math.min(height[left], height[right]);
            result = Math.max(result, val);
            if (height[left] >= height[right]) {
                while (right > 0 && height[right - 1] <= height[right]) {
                    --right;
                }
                --right;
            } else {
                while (left < n - 1 && height[left + 1] <= height[left]) {
                    ++left;
                }
                ++left;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] h = {1, 1};
        System.out.println((new Problem11()).maxArea(h));
    }
}
