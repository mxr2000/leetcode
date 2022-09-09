package com.mxr.demo;

public class Problem1864 {
    public int minSwaps(String s) {
        int cnt = 0;
        for (char ch : s.toCharArray()) {
            cnt += ch == '0' ? 0 : 1;
        }
        if (Math.abs(cnt - (s.length() - cnt)) > 1) {
            return -1;
        }
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < s.length(); i += 2) {
            cnt1 += s.charAt(i) == '1' ? 0 : 1;
        }
        for (int i = 1; i < s.length(); i += 2) {
            cnt2 += s.charAt(i) == '1' ? 0 : 1;
        }
        return s.length() % 2 == 0 ? Math.min(cnt1, cnt2) : (cnt > (s.length() - cnt) ? cnt1 : cnt2);
    }
}
