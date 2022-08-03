package com.mxr.demo;

public class Problem551 {
    public boolean checkRecord(String s) {
        int late = 0;
        int absentCount = 0;
        for (char ch : s.toCharArray()) {
            if (ch != 'L') {
                late = 0;
            } else {
                late++;
                if (late == 3) {
                    return false;
                }
                continue;
            }
            if (ch == 'A') {
                absentCount++;
                if (absentCount == 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
