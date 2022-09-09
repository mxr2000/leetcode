package com.mxr.demo;

import java.util.Arrays;
import java.util.Comparator;

public class Problem1874 {
    public int minProductSum(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int result = 0;
        for (int i = 0; i < nums1.length; i++) {
            result += nums1[i] * nums2[nums2.length - i - 1];
        }
        return result;
    }
}
