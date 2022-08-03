package com.mxr.demo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Problem219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int num : nums) {
            if (set.size() < k + 1) {
                if (set.contains(num)) {
                    return true;
                }
                set.add(num);
                queue.offer(num);
                continue;
            }
            set.remove(queue.poll());
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
            queue.offer(num);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println((new Problem219()).containsNearbyDuplicate(nums, 3));
    }
}
