package com.mxr.demo;

public class WordDictionary {
    static class Node {
        Node[] children = new Node[26];
        boolean end;
    }
    private final Node head = new Node();
    public WordDictionary() {

    }

    public void addWord(String word) {
        Node cur = head;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new Node();
            }
            cur = cur.children[index];
        }
        cur.end = true;
    }

    public boolean search(String word) {
        return search(word.toCharArray(), 0, head);
    }

    private boolean search(char[] arr, int index, Node cur) {
        if (cur == null) {
            return false;
        }
        if (index == arr.length) {
            return cur.end;
        }
        char ch = arr[index];
        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                if (cur.children[i] != null && search(arr, index +1, cur.children[i])) {
                    return true;
                }
            }
            return false;
        } else {
            int i = ch - 'a';
            if (cur.children[i] == null) {
                return false;
            }
            return search(arr, index + 1, cur.children[i]);
        }
    }
}
