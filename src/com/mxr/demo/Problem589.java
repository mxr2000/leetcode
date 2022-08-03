package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem589 {
    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        dfs(result, root);
        return result;
    }

    private void dfs(List<Integer> result, Node root) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        for (Node n : root.children) {
            dfs(result, n);
        }
    }
}
