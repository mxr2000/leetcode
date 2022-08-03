package com.mxr.demo;

import java.util.Deque;
import java.util.LinkedList;

public class Problem125 {
    public boolean isPalindrome(String s) {
        String lower = s.toLowerCase();
        Deque<Character> deque = new LinkedList<>();
        for (char ch : lower.toCharArray()) {
            if (Character.isAlphabetic(ch) || Character.isDigit(ch)) {
                deque.addLast(ch);
            }
        }
        while (!deque.isEmpty() && deque.size() != 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println((new Problem125()).isPalindrome("0P"));
    }
}
