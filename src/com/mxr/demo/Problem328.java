package com.mxr.demo;

public class Problem328 {
    public ListNode oddEvenList(ListNode head) {
        ListNode head2 = null;
        ListNode tail2 = null;
        ListNode last = null;
        ListNode current = head;
        boolean toRemove = false;
        while (current != null) {
            ListNode next = current.next;
            if (toRemove) {
                if (tail2 == null) {
                    head2 = tail2 = current;
                } else {
                    tail2.next = current;
                    tail2 = current;
                }
            } else {
                if (last == null) {
                    last = current;
                } else {
                    last.next = current;
                    last = current;
                }
            }
            current = next;
            toRemove = !toRemove;
        }
        if (last != null) {
            last.next = head2;
        }
        if (tail2 != null) {
            tail2.next = null;
        }
        return head;
    }
}
