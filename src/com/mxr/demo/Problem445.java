package com.mxr.demo;

import java.util.Stack;

public class Problem445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        int carriage = 0;
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        ListNode head = null;
        while (!s1.empty() && !s2.empty()) {
            int val = carriage + s1.pop() + s2.pop();
            ListNode newHead = null;
            if (val >= 10) {
                newHead = new ListNode(val - 10);
                carriage = 1;
            } else {
                newHead = new ListNode(val);
                carriage = 0;
            }
            newHead.next = head;
            head = newHead;
        }
        if (!s1.empty() || !s2.empty()) {
            Stack<Integer> s = s1.isEmpty() ? s2 : s1;
            while (!s.isEmpty()) {
                int val = s.pop() + carriage;
                ListNode newHead = null;
                if (val >= 10) {
                    newHead = new ListNode(val - 10);
                    carriage = 1;
                } else {
                    newHead = new ListNode(val);
                    carriage = 0;
                }
                newHead.next = head;
                head = newHead;
            }
        }
        if (carriage == 1) {
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            head = newHead;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(7);
        l2.next = new ListNode(3);
        ListNode result = (new Problem445()).addTwoNumbers(l1, l2);
        System.out.println();
    }
}
