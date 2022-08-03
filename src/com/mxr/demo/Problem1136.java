package com.mxr.demo;

import java.util.*;

public class Problem1136 {
    public int minimumSemesters(int n, int[][] relations) {
        Set<Integer>[] pres = new Set[n];
        Set<Integer>[] posts = new Set[n];
        List<Integer> unfinished = new LinkedList<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            pres[i] = new HashSet<>();
            posts[i] = new HashSet<>();
        }
        for (int[] prerequisite : relations) {
            pres[prerequisite[0] - 1].add(prerequisite[1] - 1);
            posts[prerequisite[1] - 1].add(prerequisite[0] - 1);
        }
        List<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (pres[i].isEmpty()) {
                queue.add(i);
            } else {
                unfinished.add(i);
            }
        }
        while (!queue.isEmpty()) {
            List<Integer> newQueue = new LinkedList<>();
            List<Integer> newList = new LinkedList<>();
            for (int toRemoveIndex : queue) {
                for (int index : posts[toRemoveIndex]) {
                    pres[index].remove(toRemoveIndex);
                }
            }
            for (int index : unfinished) {
                if (pres[index].isEmpty()) {
                    newQueue.add(index);
                } else {
                    newList.add(index);
                }
            }
            unfinished = newList;
            queue = newQueue;
            cnt++;
        }
        if (unfinished.isEmpty()) {
            return cnt;
        } else {
            return -1;
        }
    }
}
