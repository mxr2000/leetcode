package com.mxr.demo;

import java.util.*;
import java.util.stream.Collectors;

public class Problem451 {
    public String frequencySort(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }
        return frequencyMap
                .keySet()
                .stream()
                .map(ch -> new int[] {(int) ch, frequencyMap.get(ch)})
                .sorted(Comparator.comparingInt(pair -> -pair[1]))
                .map(info -> ("" + (char) info[0]).repeat(info[1]))
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println((new Problem451()).frequencySort("tree"));
    }
}
