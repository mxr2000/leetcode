package com.mxr.demo;

public class Problem203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode current = head;
        ListNode last = null;
        while (current != null) {
            if (current.val == val) {
                if (last == null) {
                    head = head.next;
                } else {
                    last.next = current.next;
                }
            } else {
                last = current;
            }
            current = current.next;
        }
        return head;
    }
}
