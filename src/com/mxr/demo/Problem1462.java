package com.mxr.demo;

import java.util.*;

public class Problem1462 {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> result = new ArrayList<>();
        boolean[][] connected = new boolean[numCourses][numCourses];
        for (int[] p : prerequisites) {
            connected[p[0]][p[1]] = true;
        }
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    connected[i][j] = connected[i][j] || (connected[i][k] && connected[k][j]);
                }
            }
        }
        for (int[] query : queries) {
            result.add(connected[query[0]][query[1]]);
        }
        return result;
    }


    public static void main(String[] args) {
        int[][] pre = {
                {1, 0}
        };
        int[][] queries = {
                {0, 1},
                {1, 0}
        };
        System.out.println((new Problem1462()).checkIfPrerequisite(2, pre, queries));
    }
}
