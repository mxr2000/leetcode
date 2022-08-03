package com.mxr.demo;

public class Problem92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode theLast = null, theNext = null, newHead = null, newTail = null;
        ListNode current = head;
        int index = 1;
        while (current != null) {
            ListNode next = current.next;
            if (index == left - 1) {
                theLast = current;
            } else if (index == right + 1) {
                theNext = current;
                break;
            } else if (index >= left && index <= right) {
                if (newHead == null) {
                    newHead = newTail = current;
                } else {
                    current.next = newHead;
                    newHead = current;
                }
            }
            current = next;
            ++index;
        }
        if (theLast != null) {
            theLast.next = newHead;
        }
        if (newTail != null) {
            newTail.next = theNext;
        }
        return theLast == null ? newHead : head;
    }
}
