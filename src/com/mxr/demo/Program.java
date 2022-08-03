package com.mxr.demo;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        Program program = new Program();
        int[] X = {1, 1, 1};
        int[] Y = {2, 2, 2};
        System.out.println(program.solution(X, Y));
    }
    public int solution(int[] X, int[] Y) {
        int common = common(Y);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < X.length; i++) {
            list.add(X[i] * (common / Y[i]));
        }

        return solve(list, 0, common);
    }
    public int solve(List<Integer> list, int from, int target) {
        if (target == 0) {
            return 1;
        } else if (target < 0) {
            return 0;
        }
        int cnt = 0;
        for (int i = from; i < list.size(); i++) {
            cnt += solve(list, i + 1, target - list.get(i));
        }
        return cnt;
    }
    private int common(int[] Y) {
        Set<Integer> set = new HashSet<>();
        for (int j : Y) {
            set.add(j);
        }
        List<Integer> list = new ArrayList<>(List.copyOf(set));
        Collections.sort(list);
        int current = 2;
        int value = 1;
        while (current <= list.get(0)) {
            boolean ok = true;
            for (int num : list) {
                if (num % current != 0) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                for (int i = 0; i < list.size(); i++) {
                    list.set(i, list.get(i) / current);
                }
                value *= current;
            } else {
                current++;
            }
        }
        for (int num : list) {
            value *= num;
        }
        return value;
    }
}
