package com.mxr.demo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProductOfNumbers {
    private final List<Integer> prefix = new ArrayList<>();

    public ProductOfNumbers() {
        prefix.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            prefix.clear();
            prefix.add(1);
        } else {
            prefix.add(prefix.get(prefix.size() - 1) * num);
        }
    }

    public int getProduct(int k) {
        return k > prefix.size() ? 0 : prefix.get(prefix.size() - 1) / prefix.get(prefix.size() - k);
    }
}
