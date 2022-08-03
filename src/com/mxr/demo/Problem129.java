package com.mxr.demo;

public class Problem129 {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        calculate(root, 0);
        return sum;
    }

    private void calculate(TreeNode root, int value) {
        if (root == null) {
            return;
        }
        value = value * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += (value);
            return;
        }
        calculate(root.left, value);
        calculate(root.right, value);
    }
}
