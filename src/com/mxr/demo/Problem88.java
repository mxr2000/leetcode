package com.mxr.demo;

import java.util.Arrays;

public class Problem88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mIndex = m - 1;
        int nIndex = n - 1;
        while (mIndex >= 0 && nIndex >= 0) {
            int index = m + n - (m - mIndex - 1) - (n - nIndex - 1) - 1;
            if (nums1[mIndex] < nums2[nIndex]) {
                nums1[index] = nums2[nIndex--];
            } else {
                nums1[index] = nums1[mIndex--];
            }
        }
        while (nIndex >= 0) {
            nums1[nIndex] = nums2[nIndex];
            nIndex--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 0};
        int[] nums2 = {2};
        (new Problem88()).merge(nums1, 1, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }
}
