package com.mxr.demo;

import java.util.Stack;

public class Problem678 {
    public static void main(String[] args) {
        System.out.println((new Problem678()).checkValidString("(*)))"));
    }

    public boolean checkValidString(String s) {
        int low = 0, high = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                --low;
                ++high;
            } else if (ch == '(') {
                ++low;
                ++high;
            } else if (ch == ')') {
                --high;
                --low;
            }
            if (high < 0) {
                return false;
            }
            low = Math.max(low, 0);
        }
        return low == 0;
    }

}
