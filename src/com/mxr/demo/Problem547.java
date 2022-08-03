package com.mxr.demo;

import java.util.HashSet;
import java.util.Set;

public class Problem547 {
    public int findCircleNum(int[][] isConnected) {
        int cnt = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < isConnected.length; i++) {
            set.add(i);
        }
        for (int i = 0; i < isConnected.length; i++) {
            if (set.contains(i)) {
                process(set, isConnected, i);
                cnt++;
            }
        }
        return cnt;
    }
    private void process(Set<Integer> set, int[][] isConnected, int index) {
        if (!set.contains(index)) {
            return;
        }
        set.remove(index);
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[index][i] == 1) {
                process(set, isConnected, i);
            }
        }
    }

    public static void main(String[] args) {
        int[][] map = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println((new Problem547()).findCircleNum(map));
    }
}
