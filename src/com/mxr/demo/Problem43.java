package com.mxr.demo;

public class Problem43 {
    public String multiply(String num1, String num2) {
        String result = "";
        for (int i = 0; i < num2.length(); i++) {
            result = add(result, multiplyBySingle(num1, num2.charAt(num2.length() - i - 1) - '0') + "0".repeat(i));
        }
        while (result.length() > 1 && result.charAt(0) == '0') {
            result = result.substring(1);
        }
        return result;
    }

    private String multiplyBySingle(String num, int n) {
        StringBuilder sb = new StringBuilder();
        int carriage = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            int p = (num.charAt(i) - '0') * n + carriage;
            sb.insert(0, (char) ('0' + p % 10));
            carriage = p / 10;
        }
        if (carriage > 0) {
            sb.insert(0, (char) ('0' + carriage));
        }
        return sb.toString();
    }

    private String add(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int c = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.min(m, n); i++) {
            int i1 = m - i - 1, i2 = n - i - 1;
            int n1 = num1.charAt(i1) - '0', n2 = num2.charAt(i2) - '0';
            int r = n1 + n2 + c;
            sb.insert(0, (char) ('0' + r % 10));
            c = r / 10;
        }
        String s = m > n ? num1 : num2;
        for (int i = 0; i < Math.abs(m - n); i++) {
            int index = Math.max(m, n) - Math.min(m, n) - i - 1;
            int d = s.charAt(index) - '0';
            int r = d + c;
            sb.insert(0, (char) ('0' + r % 10));
            c = r / 10;
        }
        if (c != 0) {
            sb.insert(0, (char) ('0' + c));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println((new Problem43()).multiply("9133", "0"));
    }
}
