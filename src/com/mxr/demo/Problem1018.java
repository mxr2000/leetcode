package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem1018 {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum * 2 + nums[i];
            result.add(sum % 5 == 0);
            sum %= 5;
        }

        return result;
    }
}
