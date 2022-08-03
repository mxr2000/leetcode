package com.mxr.demo;

public class Problem437 {
    private int total = 0;

    public int pathSum(TreeNode root, int targetSum) {
        traverse(root, targetSum);
        return total;
    }

    private void traverse(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        dfs(root, targetSum, 0);
        traverse(root.left, targetSum);
        traverse(root.right, targetSum);
    }

    public void dfs(TreeNode root, int targetSum, int current) {
        if (root == null) {
            return;
        }
        current += root.val;
        if (current == targetSum) {
            total += 1;
        } else {
            dfs(root.left, targetSum, current);
            dfs(root.right, targetSum, current);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{1,-2,-3,1,3,-2,null,-1});
        System.out.println((new Problem437()).pathSum(root, -1));
    }
}
