package com.mxr.demo;

import java.util.*;

public class Problem207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer>[] pres = new Set[numCourses];
        List<Integer> unfinished = new LinkedList<>();
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
        return unfinished.isEmpty();
    }

    public static void main(String[] args) {
        int[][] pres = {
                {1, 0},
                {0, 1}
        };
        System.out.println((new Problem207()).canFinish(2, pres));
    }
}
