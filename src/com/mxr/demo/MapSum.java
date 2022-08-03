package com.mxr.demo;

public class MapSum {
    static class Node {
        Node[] children = new Node[26];
        int val;
    }

    private final Node head = new Node();

    public MapSum() {

    }

    public void insert(String key, int val) {
        Node cur = head;
        for (char ch : key.toCharArray()) {
            int index = ch - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new Node();
            }
            cur = cur.children[index];
        }
        cur.val = val;
    }

    public int sum(String prefix) {
        Node cur = head;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (cur.children[index] == null) {
                return 0;
            }
            cur = cur.children[index];
        }
        return dfs(cur);
    }

    private int dfs(Node node) {
        if (node == null) {
            return 0;
        }
        int result = node.val;
        for (int i = 0; i < 26; i++) {
            result += dfs(node.children[i]);
        }
        return result;
    }
}
