package com.mxr.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Problem496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] result = new int[m];
        int[] greater = new int[n];
        Arrays.fill(greater, -1);
        Map<Integer, Integer> indexes = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            indexes.put(nums2[i], i);
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                greater[stack.pop()] = nums2[i];
            }
            stack.push(i);
        }
        for (int i = 0; i < m; i++) {
            result[i] = greater[indexes.get(nums1[i])];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString((new Problem496()).nextGreaterElement(nums1, nums2)));
    }
}
