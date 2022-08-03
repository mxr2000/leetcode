package com.mxr.demo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Problem752 {
    public int openLock(String[] deadends, String target) {
        Set<Integer> visited = new HashSet<>();
        for (String end : deadends) {
            visited.add(getCnt(end));
        }
        int result = 0;
        List<Integer> frontier = new LinkedList<>();
        if (!visited.contains(0)) {
            frontier.add(0);
        }
        visited.add(0);
        int t = getCnt(target);
        while (!frontier.isEmpty()) {
            List<Integer> newFrontier = new LinkedList<>();
            for (int p : frontier) {
                if (p == t) {
                    return result;
                }
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 2; j++) {
                        int n = flip(p, i, j);
                        if (visited.contains(n) ) {
                            continue;
                        }
                        newFrontier.add(n);
                        visited.add(n);
                    }
                }
            }
            frontier = newFrontier;
            ++result;
        }
        return -1;
    }

    private int getCnt(String p) {
        int result = 0;
        for (char ch : p.toCharArray()) {
            result = result * 10 + (ch - '0');
        }
        return result;
    }

    private int flip(int original, int index, int up) {
        int result = 0;
        int base = 1;
        for (int i = 0; i < 4; i++) {
            int n = original % 10;
            int newN;
            if (i == index) {
                if (up == 1) {
                    if (n == 9) {
                        newN = 0;
                    } else {
                        newN = n + 1;
                    }
                } else {
                    if (n == 0) {
                        newN = 9;
                    } else {
                        newN = n - 1;
                    }
                }
            } else {
                newN = n;
            }
            result += base * newN;
            base *= 10;
            original /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] ends = {"0000"};
        System.out.println((new Problem752()).openLock(ends, "0202"));
    }
}
