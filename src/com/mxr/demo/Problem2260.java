package com.mxr.demo;

import java.util.HashMap;
import java.util.Map;

public class Problem2260 {
    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < cards.length; i++) {
            int num = cards[i];
            if (!map.containsKey(num)) {
                map.put(num, i);
            } else {
                int cnt = i - map.get(num) + 1;
                min = Math.min(cnt, min);
                map.put(num, i);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        int[] cards = {3, 4, 2, 3, 4, 7};
        System.out.println((new Problem2260()).minimumCardPickup(cards));
    }
}
