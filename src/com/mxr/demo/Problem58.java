package com.mxr.demo;

public class Problem58 {
    public int lengthOfLastWord(String s) {
        String[] parts = s.split(" ");
        return parts[parts.length - 1].length();
    }

    public static void main(String[] args) {
        System.out.println((new Problem58()).lengthOfLastWord("   fly me   to   the moon  "));
    }
}
