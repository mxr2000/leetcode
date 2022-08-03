package com.mxr.demo;

public class MyCircularQueue {
    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    private Node head, tail;
    private int k, size;
    public MyCircularQueue(int k) {
        this.k = k;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        ++size;
        if (head == null) {
            head = tail = new Node(value);
        } else {
            tail.next = new Node(value);
            tail = tail.next;
        }
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        --size;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
        return true;
    }

    public int Rear() {
        if (tail == null) {
            return -1;
        }
        return tail.val;
    }

    public int Front() {
        if (head == null) {
            return -1;
        }
        return head.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == k;
    }

    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(2);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.deQueue();
        queue.enQueue(3);
        queue.deQueue();
        queue.enQueue(3);
        queue.deQueue();
        queue.enQueue(3);
        queue.deQueue();
        System.out.println(queue.Rear());
    }
}
