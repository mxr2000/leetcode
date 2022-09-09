package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        for (int a = 1; a <= 3; a++) {
            for (int b = 1; b <= 3; b++) {
                for (int c = 1; c <= 3; c++) {
                    for (int d = 1; d <= 3; d++) {
                        if (a + b + c + d != s.length()) {
                            continue;
                        }
                        int n1 = Integer.parseInt(s.substring(0, a));
                        int n2 = Integer.parseInt(s.substring(a, a + b));
                        int n3 = Integer.parseInt(s.substring(a + b, a + b + c));
                        int n4 = Integer.parseInt(s.substring(a + b + c, a + b + c + d));
                        if (n1 >= 0 && n1 <= 255 && n2 >= 0 && n2 <= 255 && n3 >= 0 && n3 <= 255 && n4 >= 0 && n4 <= 255) {
                            String combined = String.format("%d.%d.%d.%d", n1, n2, n3, n4);
                            if (combined.length() == s.length() + 3) {
                                result.add(combined);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
