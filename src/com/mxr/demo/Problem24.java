package com.mxr.demo;

public class Problem24 {
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = (head != null && head.next != null) ? head.next : head;
        ListNode last = null;
        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;
            if (last != null) {
                last.next = second;
            }
            ListNode next = second.next;
            second.next = first;
            first.next = next;
            last = first;
            head = first.next;
        }
        return newHead;
    }
}
