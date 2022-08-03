package com.mxr.demo;

import java.util.HashMap;
import java.util.Map;

public class FileSystem {
    static class Node {
        Map<String, Node> children = new HashMap<>();
        int val;
    }
    private final Node head = new Node();
    public FileSystem() {

    }

    public boolean createPath(String path, int value) {
        String[] parts = path.split("/");
        Node cur = head;
        for (int i = 1; i < parts.length - 1; i++) {
            String p = parts[i];
            if (!cur.children.containsKey(p)) {
                return false;
            }
            cur = cur.children.get(p);
        }
        if (cur.children.containsKey(parts[parts.length - 1])) {
            return false;
        }
        Node node;
        cur.children.put(parts[parts.length - 1], node = new Node());
        node.val = value;
        return true;
    }

    public int get(String path) {
        Node cur = head;
        String[] parts = path.split("/");
        for (String p : parts) {
            if ("".equals(p)) {
                continue;
            }
            if (!cur.children.containsKey(p)) {
                return -1;
            }
            cur = cur.children.get(p);
        }
        return cur.val == 0 ? -1 : cur.val;
    }

    public static void main(String[] args) {
        FileSystem system = new FileSystem();
        system.createPath("/a", 1);
        System.out.println(system.get("/a"));
    }
}
