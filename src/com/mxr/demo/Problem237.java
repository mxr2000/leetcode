package com.mxr.demo;

public class Problem237 {
    public void deleteNode(ListNode node) {
        ListNode cur = node, next = node.next;
        while (next != null) {
            cur.val = next.val;
            if (next.next == null) {
                cur.next = null;
                break;
            } else {
                cur = next;
                next = next.next;
            }
        }
    }
}
