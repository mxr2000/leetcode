package com.mxr.demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem179 {
    public String largestNumber(int[] nums) {
        StringBuffer buffer = new StringBuffer();
        String[] strValues = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strValues[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strValues, (a, b) -> (b + a).compareTo(a + b));
        if (strValues[0].equals("0")) {
            return "0";
        }
        for (int i = 0; i < nums.length; i++) {
            buffer.append(strValues[i]);
        }
        return buffer.toString();
    }

}

/**
 * a+b > b+a
 * if b+c > c+b && c+a > a+c
 */