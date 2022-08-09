package com.mxr.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1156 {
    static class Segment {
        char ch;
        int from, to;

        public Segment(char ch, int from, int to) {
            this.ch = ch;
            this.from = from;
            this.to = to;
        }
    }

    public int maxRepOpt1(String text) {
        int result = 1;
        Segment curS = null;
        List<Segment> segments = new ArrayList<>();
        Map<Character, Integer> totalCnt = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (curS == null || curS.ch != ch) {
                segments.add(curS = new Segment(ch, curS == null ? 0 : curS.to + 1, i));
            } else {
                ++curS.to;
            }
            totalCnt.put(ch, totalCnt.getOrDefault(ch, 0) + 1);
        }
        for (Segment s : segments) {
            int len = s.to - s.from + 1;
            if (totalCnt.get(s.ch) > len) {
                ++len;
            }
            result = Math.max(result, len);
        }

        for (int i = 1; i < segments.size() - 1; i++) {
            Segment former = segments.get(i - 1);
            Segment latter = segments.get(i + 1);

            if (former.ch == latter.ch && former.to + 2 == latter.from) {
                int l = latter.to - former.from + 1 - 1;
                if (totalCnt.get(former.ch) > l) {
                    ++l;
                }
                result = Math.max(result, l);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println((new Problem1156()).maxRepOpt1("ababa"));
    }
}
