package com.mxr.demo;

import java.util.Deque;
import java.util.LinkedList;

public class HitCounter {
    private final Deque<Integer> deque = new LinkedList<>();

    public HitCounter() {

    }

    public void hit(int timestamp) {
        deque.offerLast(timestamp);

    }

    public int getHits(int timestamp) {
        while (!deque.isEmpty() && deque.peekFirst() <= timestamp - 300) {
            deque.pollFirst();
        }
        return deque.size();
    }
}
