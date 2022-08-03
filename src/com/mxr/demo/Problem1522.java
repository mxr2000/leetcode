package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem1522 {
    static class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    private int result = 0;

    public int diameter(Node root) {
        dfs(root);
        return result;
    }

    private int dfs(Node root) {
        if (root == null) {
            return 0;
        }
        int first = 0, second = 0;
        for (Node child : root.children) {
            int length = dfs(child);
            if (length >= first) {
                second = first;
                first = length;
            } else if (length >= second) {
                second = length;
            }
        }
        result = Math.max(result, first + second);
        return 1 + first;
    }
}
