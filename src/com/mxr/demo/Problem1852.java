package com.mxr.demo;

import java.util.*;

public class Problem1852 {
    public int[] distinctNumbers(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> deque = new LinkedList<>();
        int cnt = 0, index = 0;
        for (int num : nums) {
            if (cnt == k) {
                --cnt;
                int pop = deque.pollFirst();
                map.put(pop, map.get(pop) - 1);
                if (map.get(pop) == 0) {
                    map.remove(pop);
                }
            }

            map.put(num, map.getOrDefault(num, 0) + 1);
            deque.offerLast(num);
            ++cnt;
            if (cnt == k) {
                result[index++] = map.size();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 1, 3};
        System.out.println(Arrays.toString((new Problem1852()).distinctNumbers(nums, 3)));
    }
}
