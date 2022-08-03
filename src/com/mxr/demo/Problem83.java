package com.mxr.demo;

import java.util.HashSet;
import java.util.Set;

public class Problem83 {
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode last = null;
        ListNode current = head;
        while (current != null) {
            if (set.contains(current.val)) {
                last.next = current.next;
            } else {
                set.add(current.val);
                last = current;
            }
            current = current.next;
        }
        return head;
    }
}
