package com.mxr.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem735 {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> results = new ArrayList<>();
        List<Integer> finalResults = results;
        Arrays.stream(asteroids).forEach(finalResults::add);
        for (int num : asteroids) {
            List<Integer> newResults = new ArrayList<>();
            boolean handled = false;
            for (int i = results.size() - 1; i >= 0; i--) {
                int dumb = results.get(i);
                if (handled) {
                    newResults.add(0, dumb);
                }
                if (dumb * num < 0) {
                    if (Math.abs(num) == Math.abs(dumb)) {
                        handled = true;
                    } else if (Math.abs(num) > Math.abs(dumb)) {
                    } else {
                        newResults.add(dumb);
                        handled = true;
                    }
                } else {
                    handled = true;
                    newResults.add(dumb);
                    newResults.add(num);
                }
            }
            results = newResults;
        }
        int[] ret = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            ret[i] = results.get(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString((new Problem735()).asteroidCollision(new int[]{5, 10, -5})));
    }
}
