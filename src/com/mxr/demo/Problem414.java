package com.mxr.demo;

public class Problem414 {
    public int thirdMax(int[] nums) {
        long f = Long.MIN_VALUE, s = Long.MIN_VALUE, t = Long.MIN_VALUE;
        for (int num : nums) {
            if (num > f) {
                t = s;
                s = f;
                f = num;
            } else if (num < f && num > s) {
                t = s;
                s = num;
            } else if (num < s && num > t) {
                t = num;
            }
        }
        return (int) (t == Long.MIN_VALUE ? f : t);
    }
}
