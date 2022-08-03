package com.mxr.demo;

public class Problem167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length && numbers[i] < target; i++) {
            result[0] = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    result[1] = j;
                    return result;
                } else if (numbers[i] + numbers[j] > target) {
                    break;
                }
            }
        }
        return result;
    }
}
