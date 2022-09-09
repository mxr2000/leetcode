package com.mxr.demo;

public class Problem99 {
    private TreeNode n1 = null, n2 = null, prev = null;

    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        if (n1 == null && (prev == null || prev.val >= root.val)) {
            n1 = prev;
        }
        if (n1 != null && prev.val >= root.val) {
            n2 = root;
        }
        prev = root;
        traverse(root.right);
    }
}
