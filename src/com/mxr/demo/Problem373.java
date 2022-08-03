package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int firstIndex = 0, secondIndex = 0;
        while (k > 0) {
            result.add(List.of(nums1[firstIndex], nums2[secondIndex]));
            if (firstIndex == nums1.length - 1 && secondIndex == nums2.length - 1) {
                break;
            }
            if (firstIndex == nums1.length - 1) {
                ++secondIndex;
            } else if (secondIndex == nums2.length - 1) {
                ++firstIndex;
            } else {
                if (nums1[firstIndex] + nums2[secondIndex + 1] > nums1[firstIndex + 1] + nums2[secondIndex]) {
                    ++firstIndex;
                } else {
                    ++secondIndex;
                }
            }
            --k;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        System.out.println((new Problem373()).kSmallestPairs(nums1, nums2, 3));
    }
}
