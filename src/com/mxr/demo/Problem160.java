package com.mxr.demo;

import java.util.Stack;

public class Problem160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (headA != null) {
            stack1.push(headA);
            headA = headA.next;
        }
        while (headB != null) {
            stack2.push(headB);
            headB = headB.next;
        }
        ListNode node = null;
        while (!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek() == stack2.peek()) {
            node = stack1.peek();
            stack1.pop();
            stack2.pop();
        }
        return node;
    }
}
