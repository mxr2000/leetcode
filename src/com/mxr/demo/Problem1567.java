package com.mxr.demo;

public class Problem1567 {
    public int getMaxLen(int[] nums) {
        int nCnt = 0, pCnt = 0;
        int result = 0;
        for (int num : nums) {
            if (num == 0) {
                nCnt = pCnt = 0;
            } else if (num > 0) {
                ++pCnt;
                nCnt = nCnt == 0 ? 0 : nCnt + 1;
            } else {
                if (nCnt == 0) {
                    nCnt = pCnt + 1;
                    pCnt = 0;
                } else {
                    int temp = pCnt + 1;
                    pCnt = nCnt + 1;
                    nCnt = temp;
                }
            }
            result = Math.max(result, pCnt);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2};
        System.out.println((new Problem1567()).getMaxLen(nums));
    }
}
