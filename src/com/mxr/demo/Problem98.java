package com.mxr.demo;

public class Problem98 {
    public boolean isValidBST(TreeNode root) {
        return root == null || (isValid(root.left, Integer.MIN_VALUE, root.val) && isValid(root.right, root.val, Integer.MAX_VALUE));
    }

    private boolean isValid(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.val == Integer.MIN_VALUE) {
            return root.left == null && isValid(root.right, root.val, max);
        } else if (root.val == Integer.MAX_VALUE) {
            return root.right == null && isValid(root.left, min, root.val);
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        if (root.left != null && root.left.val > root.val) {
            return false;
        }
        if (root.right != null && root.right.val < root.val) {
            return false;
        }
        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
}
