package com.mxr.demo;

public class Problem1325 {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        if (root.left != null || root.right != null) {
            root.left = removeLeafNodes(root.left, target);
            root.right = removeLeafNodes(root.right, target);
            if (root.left == null && root.right == null) {
                return removeLeafNodes(root, target);
            }
            return root;
        }
        return root.val == target ? null : root;
    }
}
