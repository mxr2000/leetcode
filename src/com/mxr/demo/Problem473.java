package com.mxr.demo;

import java.util.Arrays;

public class Problem473 {
    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) {
            return false;
        }
        int length = sum / 4;
        Arrays.sort(matchsticks);
        if (matchsticks[matchsticks.length - 1] > length) {
            return false;
        }
        return makeSquare(matchsticks, new boolean[matchsticks.length], 0, 0, length);
    }

    private boolean makeSquare(int[] sticks, boolean[] used, int lineIndex, int currentLength, int targetLength) {
        System.out.println(Arrays.toString(used));
        if (currentLength == 0 && lineIndex == 4) {
            return true;
        }
        for (int i = 0; i < sticks.length; i++) {
            if (used[i]) {
                continue;
            }
            if (sticks[i] > targetLength - currentLength) {
                continue;
            }
            used[i] = true;
            if (makeSquare(
                    sticks,
                    used,
                    lineIndex + ((currentLength + sticks[i]) == targetLength ? 1 : 0),
                    (currentLength + sticks[i]) == targetLength ? 0 : (currentLength + sticks[i]),
                    targetLength)) {
                return true;
            }
            used[i] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] sticks = {16, 5,5,5,5,4,4,4,4,4,4,3,3,3,3};
        System.out.println((new Problem473()).makesquare(sticks));
    }
}
