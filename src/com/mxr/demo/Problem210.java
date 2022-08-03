package com.mxr.demo;

import java.util.*;

public class Problem210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Set<Integer>[] pres = new Set[numCourses];
        List<Integer> unfinished = new LinkedList<>();
        int[] result = new int[numCourses];
        int cnt = 0;
        for (int i = 0; i < numCourses; i++) {
            pres[i] = new HashSet<>();
        }
        for (int[] prerequisite : prerequisites) {
            pres[prerequisite[0]].add(prerequisite[1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (pres[i].isEmpty()) {
                queue.offer(i);
            } else {
                unfinished.add(i);
            }
        }
        while (!queue.isEmpty()) {
            List<Integer> newList = new LinkedList<>();
            int toRemoveIndex = queue.poll();
            result[cnt++] = toRemoveIndex;
            for (int index : unfinished) {
                pres[index].remove(toRemoveIndex);
                if (pres[index].isEmpty()) {
                    queue.offer(index);
                } else {
                    newList.add(index);
                }
            }
            unfinished = newList;
        }
        return unfinished.isEmpty() ? result : new int[0];
    }
}
