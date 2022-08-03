package com.mxr.demo;

import java.util.List;

public class ZigzagIterator {
    private final List<Integer> v1;
    private final List<Integer> v2;
    private int index1, index2, cur;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
        index1 = 0;
        index2 = 0;
        cur = 1;
    }

    public int next() {
        int result;
        if (index1 == v1.size()) {
            result = v2.get(index2);
            ++index2;
        } else if (index2 == v2.size()) {
            result = v1.get(index1);
            ++index1;
        } else {
            if (cur == 1) {
                result = v1.get(index1++);
                cur = 2;
            } else {
                result = v2.get(index2++);
                cur = 1;
            }
        }
        return result;
    }

    public boolean hasNext() {
        if (index1 == v1.size()) {
            return index2 < v2.size();
        } else if (index2 == v2.size()) {
            return index1 < v1.size();
        }
        return cur == 1 ? index1 < v1.size() : index2 < v2.size();
    }
}
