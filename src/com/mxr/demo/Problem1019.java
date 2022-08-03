package com.mxr.demo;

import java.util.Stack;

public class Problem1019 {
    public int[] nextLargerNodes(ListNode head) {
        Stack<int[]> stack = new Stack<>();
        int size = getLength(head);
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            while (!stack.isEmpty() && head.val > stack.peek()[1]) {
                int[] info = stack.pop();
                result[info[0]] = head.val;
            }
            stack.push(new int[] {i, head.val});
            head = head.next;
        }
        return result;
    }

    private int getLength(ListNode head) {
        int size = 0;
        while (head != null) {
            ++size;
            head = head.next;
        }
        return size;
    }
}
