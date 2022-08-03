package com.mxr.demo;

import java.util.LinkedList;
import java.util.Queue;

public class Problem206 {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            if (newHead == null) {
                newHead = head;
                head.next = null;
            } else {
                head.next = newHead;
                newHead = head;
            }
            head = next;
        }
        return newHead;
    }
}
