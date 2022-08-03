package com.mxr.demo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Problem350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new LinkedList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i1 = 0, i2 = 0;
        while (i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1] == nums2[i2]) {
                result.add(nums1[i1]);
                ++i1;
                ++i2;
            } else if (nums1[i1] > nums2[i2]) {
                ++i2;
            } else {
                ++i1;
            }
        }
        return result.stream().mapToInt(a -> a).toArray();
    }
}
