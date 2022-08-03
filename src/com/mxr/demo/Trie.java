package com.mxr.demo;

public class Trie {
    static class Node {
        Node[] children = new Node[26];
        boolean hasWord;
    }
    private final Node head = new Node();
    public Trie() {

    }

    public void insert(String word) {
        Node cur = head;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new Node();
            }
            cur = cur.children[index];
        }
        cur.hasWord = true;
    }

    public boolean search(String word) {
        Node node = getNode(word);
        return node != null && node.hasWord;
    }

    public boolean startsWith(String prefix) {
        return getNode(prefix) != null;
    }

    private Node getNode(String word) {
        Node cur = head;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (cur.children[index] == null) {
                return null;
            }
            cur = cur.children[index];
        }
        return cur;
    }
}
