package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem784 {
    public List<String> letterCasePermutation(String s) {
        List<String> results = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                buffer.append(ch);
                continue;
            }
            List<String> latter = letterCasePermutation(s.substring(i + 1));

            for (String l : latter) {
                String result = buffer.toString() + Character.toUpperCase(ch) + l;
                results.add(result);
                result = buffer.toString() + Character.toLowerCase(ch) + l;
                results.add(result);
            }
            return results;
        }

        results.add(buffer.toString());
        return results;
    }

    public static void main(String[] args) {
        System.out.println((new Problem784()).letterCasePermutation("3z4"));
    }
}
