package com.mxr.demo;

public class Problem572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return subRoot == null;
        }
        if (isSame(root, subRoot)) {
            return true;
        }
        return isSame(root.left, subRoot) || isSame(root.right, subRoot);
    }

    private boolean isSame(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return root == null;
        }
        if (root == null) {
            return false;
        }
        return root.val == subRoot.val && isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
    }
}
