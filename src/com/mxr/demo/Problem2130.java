package com.mxr.demo;

import java.util.Deque;
import java.util.LinkedList;

public class Problem2130 {
    public int pairSum(ListNode head) {
        Deque<Integer> deque = new LinkedList<>();
        while (head != null) {
            deque.offerLast(head.val);
            head = head.next;
        }
        int result = 0;
        while (!deque.isEmpty()) {
            int sum = deque.pollFirst() + deque.pollLast();
            result = Math.max(result, sum);
        }
        return result;
    }
}
