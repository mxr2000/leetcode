package com.mxr.demo;

import java.util.Arrays;

public class Problem725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int fullLength = getLength(head);
        int length = fullLength % k == 0 ? fullLength / k : (fullLength / k + 1);
        ListNode[] result = new ListNode[k];
        for (int i = 0; i < k && head != null; i++) {
            result[i] = head;
            ListNode last = head;
            head = head.next;
            for (int j = 1; j < length && head != null; j++) {
                last = head;
                head = head.next;
            }
            last.next = null;
        }
        return result;
    }

    private int getLength(ListNode head) {
        int result = 0;
        while (head != null) {
            ++result;
            head = head.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println(Arrays.toString((new Problem725()).splitListToParts(n1, 3)));
    }
}
