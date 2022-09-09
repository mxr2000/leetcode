package com.mxr.demo;

public class Problem680 {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return check(s, i + 1, j) || check(s, i, j + 1);
            }
            ++i;
            --j;
        }
        return true;
    }

    private boolean check(String s, int from, int to) {
        while (from < to) {
            if (s.charAt(from) != s.charAt(to)) {
                return false;
            }
            ++from;
            --to;
        }
        return true;
    }


    public static void main(String[] args) {
        String encoded = "23511011501782351112179911801562340161171141148";
        encoded = (new StringBuilder(encoded)).reverse().toString();
        StringBuilder sb = new StringBuilder();
        int index = encoded.length() - 1;
        while (index >= 0) {
            int length = 2;
            if (index >= 1 && encoded.charAt(index - 1) == '0' || encoded.charAt(index - 1) == '1' || encoded.charAt(index - 1) == '2') {
                length = 3;
            }
            String p = encoded.substring(index - length + 1, index + 1);
            sb.insert(0, (char) Integer.parseInt(p));
            index -= length;
        }

        String res = sb.toString();
        System.out.println(res);
    }

}
