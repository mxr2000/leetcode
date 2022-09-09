package com.mxr.demo;

import java.util.HashMap;
import java.util.Map;

public class Problem2365 {
    public long taskSchedulerII(int[] tasks, int space) {
        long result = 0;
        Map<Integer, Long> last = new HashMap<>();
        for (int type : tasks) {
            if (!last.containsKey(type) || last.get(type) + space <= result) {
                ++result;
            } else {
                result += (space - (result - last.get(type)) + 1);
            }
            last.put(type, result);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] tasks = {1, 2, 1, 2, 3, 1};
        System.out.println((new Problem2365()).taskSchedulerII(tasks, 3));
    }
}
