package com.mxr.demo;

public class Problem897 {
    TreeNode head, tail;
    public TreeNode increasingBST(TreeNode root) {
        dfs(root);
        return head;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        TreeNode node = new TreeNode();
        node.val = root.val;
        if (head == null) {
            head = tail = node;
        } else {
            tail.right = node;
            tail = node;
        }
        dfs(root.right);
    }
}
