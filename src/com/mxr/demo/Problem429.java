package com.mxr.demo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem429 {
    static class Node {
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

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> results = new ArrayList<>();

        List<Node> row = new ArrayList<>();
        if (root != null) {
            row.add(root);
        }
        while (!row.isEmpty()) {
            List<Integer> result = new ArrayList<>();
            List<Node> newRow = new ArrayList<>();
            for (Node node : row) {
                result.add(node.val);
                newRow.addAll(node.children);
            }
            row = newRow;
            results.add(result);
        }

        return results;
    }

    public static void main(String[] args) {
        System.out.println((new Problem429()).levelOrder(null));
    }
}
