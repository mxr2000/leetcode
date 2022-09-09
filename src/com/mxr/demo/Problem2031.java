package com.mxr.demo;

import java.util.HashMap;
import java.util.Map;

public class Problem2031 {
    public int subarraysWithMoreZerosThanOnes(int[] nums) {
        int result = 0, sum = 0;
        int mod = 1000000007;
        int cntEqual = 0, cntMore = 0;
        Map<Integer, Integer> zeroCnt = new HashMap<>();
        zeroCnt.put(0, 1);
        for (int num : nums) {
            int newCntEqual, newCntMore;
            sum += num == 1 ? 1 : -1;
            newCntEqual = zeroCnt.getOrDefault(sum, 0);
            if (num == 1) {
                newCntMore = (cntMore + cntEqual + 1) % mod;
            } else {
                newCntMore = (cntMore - newCntEqual + mod) % mod;
            }
            zeroCnt.put(sum, zeroCnt.getOrDefault(sum, 0) + 1);
            result = (result + newCntMore) % mod;
            cntEqual = newCntEqual;
            cntMore = newCntMore;
        }
        return result;
    }
}
