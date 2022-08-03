package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem38 {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = get(s);
        }
        return s;
    }

    String get(String s) {
        char current = s.charAt(0);
        int cnt = 1;
        StringBuffer buffer = new StringBuffer();
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == current) {
                cnt++;
            } else {
                buffer.append(cnt);
                buffer.append(current);
                current = ch;
                cnt = 1;
            }
        }
        buffer.append(cnt);
        buffer.append(current);
        return buffer.toString();
    }

    public static void main(String[] args) {
        System.out.println((new Problem38()).countAndSay(2));
    }
}
