package com.mxr.demo;

import java.util.*;

public class Problem1466 {
    public int minReorder(int n, int[][] connections) {
        int cnt = 0;
        Map<Integer, Set<Integer>> ins = new HashMap<>();
        Map<Integer, Set<Integer>> outs = new HashMap<>();
        for (int[] con : connections) {
            if (!ins.containsKey(con[1])) {
                ins.put(con[1], new HashSet<>());
            }
            if (!outs.containsKey(con[0])) {
                outs.put(con[0], new HashSet<>());
            }
            ins.get(con[1]).add(con[0]);
            outs.get(con[0]).add(con[1]);
        }

        List<Integer> currents = new LinkedList<>();
        currents.add(0);
        while (!currents.isEmpty()) {
            List<Integer> newList = new LinkedList<>();
            for (int index : currents) {
                if (outs.get(index) != null) {
                    List<Integer> toAdd = new ArrayList<>();
                    for (int out : outs.get(index)) {
                        cnt++;
                        toAdd.add(out);
                    }
                    for (int out : toAdd) {
                        outs.get(index).remove(out);
                        ins.computeIfAbsent(index, k -> new HashSet<>());
                        ins.get(index).add(out);
                        outs.computeIfAbsent(out, k -> new HashSet<>());
                        outs.get(out).add(index);
                        ins.get(out).remove(index);
                    }
                    newList.addAll(toAdd);
                }
                if (ins.get(index) != null) {
                    for (int in : ins.get(index)) {
                        newList.add(in);
                    }
                }
            }
            currents = newList;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] connections = {
                {0, 1},
                {1, 3},
                {2, 3},
                {4, 0},
                {4, 5}
        };
        System.out.println((new Problem1466()).minReorder(6, connections));
    }
}
