package com.mxr.demo;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Problem234 {
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> deque = new LinkedList<>();
        while (head != null) {
            deque.offerLast(head.val);
            head = head.next;
        }
        while (deque.size() > 1) {
            int front = deque.pollLast();
            int tail = deque.pollFirst();
            if (front != tail) {
                return false;
            }
        }
        return true;
    }
}
