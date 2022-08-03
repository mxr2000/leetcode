package com.mxr.demo;

public class Problem530 {
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        process(true, root.left);
        process(false, root.right);
        return min;
    }

    private int process(boolean isLeft, TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int leftMax = process(false, root.right);
        int rightMin = process(true, root.left);
        min = Math.min(min, leftMax - root.val);
        min = Math.min(min, root.val - rightMin);
        return 0;
    }

}
