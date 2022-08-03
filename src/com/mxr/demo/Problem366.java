package com.mxr.demo;

import java.util.*;

public class Problem366 {
    private final Map<TreeNode, TreeNode> parent = new HashMap<>();
    private List<TreeNode> leaves = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        dfs(root);
        List<List<Integer>> results = new ArrayList<>();
        while (!leaves.isEmpty()) {
            List<TreeNode> newLeaves = new ArrayList<>();
            results.add(leaves.stream().map(n -> n.val).toList());
            leaves.stream().filter(parent::containsKey).forEach(l -> {
                if (parent.get(l).left == l) {
                    parent.get(l).left = null;
                }
                if (parent.get(l).right == l) {
                    parent.get(l).right = null;
                }
                if (parent.get(l).left == null && parent.get(l).right == null) {
                    newLeaves.add(parent.get(l));
                }
            });
            leaves = newLeaves;
        }
        return results;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            parent.put(root.left, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right, root);
            dfs(root.right);
        }
        if (root.left == null && root.right == null) {
            leaves.add(root);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[] {1,2,3,4,5});
        System.out.println((new Problem366()).findLeaves(root));
    }
}
