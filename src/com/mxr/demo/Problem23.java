package com.mxr.demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null, tail = null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            if (node.next != null) {
                pq.offer(node.next);
            }
            node.next = null;
            if (head == null) {
                head = tail = node;
            } else {
                tail = tail.next = node;
            }
        }
        return head;
    }
}
