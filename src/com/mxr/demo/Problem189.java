package com.mxr.demo;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Problem189 {
    public void rotate(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            deque.addLast(nums[i]);
        }
        while (k > 0) {
            deque.addFirst(deque.removeLast());
            k--;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = deque.removeFirst();
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        (new Problem189()).rotate(array, 3);
        System.out.println(array);
    }
}
