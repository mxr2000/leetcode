package com.mxr.demo;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private final Deque<Integer> deque = new LinkedList<>();
    public MyStack() {

    }

    public void push(int x) {
        deque.offerLast(x);
    }

    public int pop() {
        return deque.pollLast();
    }

    public int top() {
        return deque.peekLast();
    }

    public boolean empty() {
        return deque.isEmpty();
    }
}
