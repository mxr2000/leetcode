package com.mxr.demo;

public class Problem708 {
    static class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        Node prev = head, next = head.next;
        boolean inserted = false;
        while (true) {
            if ((prev.val <= insertVal && insertVal <= next.val) ||
                    (prev.val > next.val && insertVal < next.val) ||
                    (prev.val > next.val && insertVal > prev.val)
            ) {
                prev.next = new Node(insertVal, next);
                inserted = true;
                break;
            }
            prev = prev.next;
            next = next.next;
            if (prev == head) {
                break;
            }
        }
        if (!inserted) {
            prev.next = new Node(insertVal, next);
        }
        return head;
    }
}
