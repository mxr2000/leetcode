package com.mxr.demo;

public class Problem168 {
    public String convertToTitle(int columnNumber) {
        String ret = "";
        while (columnNumber > 0) {
            int value = columnNumber % 26;
            ret = (char)('A' + value - 1) + ret;
            columnNumber /= 26;
        }
        return ret;
    }
}
