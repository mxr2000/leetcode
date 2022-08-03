package com.mxr.demo;

public class MyCircularDeque {
    static class Node {
        int val;
        Node next, prev;

        public Node(int val) {
            this.val = val;
        }
    }

    private final int k;
    private int size = 0;
    private final Node head, tail;
    public MyCircularDeque(int k) {
        this.k = k;
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        ++size;
        Node next = head.next;
        Node node = new Node(value);
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        ++size;
        Node prev = tail.prev;
        Node node = new Node(value);
        tail.prev = node;
        node.next = tail;
        node.prev = prev;
        prev.next = node;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        --size;
        Node next = head.next;
        head.next = next.next;
        head.next.prev = head;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        --size;
        Node prev = tail.prev;
        tail.prev = prev.prev;
        tail.prev.next = tail;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return head.next.val;
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return tail.prev.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == k;
    }
}
