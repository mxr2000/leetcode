package com.mxr.demo;

import java.util.*;

public class Problem692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Object[]> pq = new PriorityQueue<Object[]>((p1, p2) -> {
            String w1 = (String) p1[0], w2 = (String) p2[0];
            Integer f1 = (Integer) p1[1], f2 = (Integer) p2[1];
            return (int) f1 != f2 ? f1.compareTo(f2) : w2.compareTo(w1);
        });
        for (String key : map.keySet()) {
            pq.offer(new Object[]{key, map.get(key)});
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<String> result = new LinkedList<>();
        while (!pq.isEmpty()) {
            result.add(0, (String) pq.poll()[0]);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        System.out.println((new Problem692()).topKFrequent(words, 4));
    }

}
