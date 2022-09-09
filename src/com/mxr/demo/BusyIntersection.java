package com.mxr.demo;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BusyIntersection {
    public static List<Integer> getResult(List<Integer> arrival, List<Integer> street) {
        Queue<Integer> q0 = new LinkedList<>(), q1 = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arrival.size(); i++) {
            result.add(0);
        }
        int time = 0, index = 0, last = -1;
        while (!(index == arrival.size() && q0.isEmpty() && q1.isEmpty())) {
            while (index < arrival.size() && arrival.get(index) == time) {
                Queue<Integer> q = street.get(index) == 0 ? q0 : q1;
                q.offer(index);
                ++index;
            }
            if (q0.isEmpty() && q1.isEmpty()) {
                last = -1;
            } else if (last == -1) {
                if (!q1.isEmpty()) {
                    result.set(q1.poll(), time);
                    last = 1;
                } else {
                    result.set(q0.poll(), time);
                    last = 0;
                }
            } else if (last == 0) {
                if (!q0.isEmpty()) {
                    result.set(q0.poll(), time);
                } else {
                    result.set(q1.poll(), time);
                    last = 1;
                }
            } else {
                if (!q1.isEmpty()) {
                    result.set(q1.poll(), time);
                } else {
                    result.set(q0.poll(), time);
                    last = 0;
                }
            }
            if (q0.isEmpty() && q1.isEmpty() && index < arrival.size() && time < arrival.get(index)) {
                time = arrival.get(index);
            } else {
                ++time;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> arrival = List.of(6, 6, 6, 6), street = List.of(0, 1, 0, 1);
        System.out.println(getResult(arrival, street));

    }
}
