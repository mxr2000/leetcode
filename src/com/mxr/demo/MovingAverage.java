package com.mxr.demo;

import java.util.Deque;
import java.util.LinkedList;

public class MovingAverage {
    int sum = 0;
    int size;
    Deque<Integer> deque = new LinkedList<>();
    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        sum += val;
        deque.offerLast(val);
        if (deque.size() > size) {
            sum -= deque.pollFirst();
        }
        return sum * 1.0 / deque.size();
    }
}
