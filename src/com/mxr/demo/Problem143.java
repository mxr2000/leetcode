package com.mxr.demo;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Problem143 {
    public void reorderList(ListNode head) {
        Deque<ListNode> deque = new LinkedList<>();
        ListNode current = head;
        while (current != null) {
            deque.offer(current);
            current = current.next;
        }
        current = head;
        while (!deque.isEmpty() && deque.size() != 1) {
            ListNode first = deque.removeFirst();
            ListNode second = deque.removeLast();
            if (current != first) {
                current.next = first;
            }
            first.next = second;
            second.next = null;
            current = second;
        }
        if (!deque.isEmpty()) {
            current.next = deque.removeFirst();
            current.next.next = null;
        }
    }
}
