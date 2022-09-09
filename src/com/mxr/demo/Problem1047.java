package com.mxr.demo;

public class Problem1047 {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < s.length()) {
            if (index < s.length() - 1 && s.charAt(index) == s.charAt(index + 1)) {
                index += 2;
                continue;
            }
            if (!sb.isEmpty() && sb.charAt(sb.length() - 1) == s.charAt(index)) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(s.charAt(index));
            }
            ++index;
        }
        return sb.toString();
    }
}
