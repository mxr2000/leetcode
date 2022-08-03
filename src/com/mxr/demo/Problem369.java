package com.mxr.demo;

import java.util.Stack;

public class Problem369 {
    public ListNode plusOne(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        ListNode newHead = null;
        int carriage = 1;
        while (!stack.isEmpty()) {
            int d = stack.pop();
            ListNode node;
            if (d + carriage >= 10) {
                node = new ListNode(d + carriage - 10);
                carriage = 1;
            } else {
                node = new ListNode(d + carriage);
                carriage = 0;
            }
            if (newHead == null) {
                newHead = node;
            } else {
                node.next = newHead;
                newHead = node;
            }
        }
        if (carriage == 1) {
            ListNode node = new ListNode(1);
            node.next = newHead;
            newHead = node;
        }
        return newHead;
    }
}
