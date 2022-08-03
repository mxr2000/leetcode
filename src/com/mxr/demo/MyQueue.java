package com.mxr.demo;

import java.util.Stack;

public class MyQueue {
    private final Stack<Integer> s1 = new Stack<>();
    private final Stack<Integer> s2 = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        while (s1.size() > 1) {
            s2.push(s1.pop());
        }
        int ret = s1.pop();
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return ret;
    }

    public int peek() {
        while (s1.size() > 1) {
            s2.push(s1.pop());
        }
        int ret = s1.peek();
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return ret;
    }

    public boolean empty() {
        return s1.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
    }
}
