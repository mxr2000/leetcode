package com.mxr.demo;

public class Problem404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum = root.left.val + sumOfLeftLeaves(root.right);
        } else {
            sum = (sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right));

        }
        return sum;
    }
}
