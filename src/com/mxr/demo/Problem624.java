package com.mxr.demo;

import java.util.List;

public class Problem624 {
    public int maxDistance(List<List<Integer>> arrays) {
        int max = -10001, min = 10001;
        int maxIndex = 0, minIndex = 0;
        int result = 0;
        for (int i = 0; i < arrays.size(); i++) {
            List<Integer> arr = arrays.get(i);
            int curMin = arr.get(0), curMax = arr.get(arr.size() - 1);
            int oldMax = max, oldMin = min;
            if (curMax > max) {
                max = curMax;
                maxIndex = i;
            }
            if (curMin < min) {
                min = curMin;
                minIndex = i;
            }
            if (maxIndex != minIndex) {
                result = Math.max(result, max - min);
            } else if (maxIndex != i) {
                result = Math.max(result, Math.max(curMax - oldMin, max - oldMax));
            }

        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> arrays = List.of(
                List.of(1, 5),
                List.of(3, 4)
        );
        System.out.println((new Problem624()).maxDistance(arrays));
    }
}
