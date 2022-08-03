package com.mxr.demo;

import java.util.*;

public class TwoSum {
    private final List<Integer> set = new LinkedList<>();

    public TwoSum() {

    }

    public void add(int number) {
        set.add(number);
    }

    public boolean find(int value) {
        if (set.size() < 2) {
            return false;
        }
        List<Integer> list = set.stream().sorted().toList();
        int from = 0, to = list.size() - 1;
        while (from != to && list.get(from) + list.get(to) != value) {
            if (list.get(from) + list.get(to) > value) {
                --to;
            } else {
                ++from;
            }
        }
        return from != to;
    }
}
