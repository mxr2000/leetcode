package com.mxr.demo;

public class Problem1315 {
    private int result = 0;

    public int sumEvenGrandparent(TreeNode root) {
        dfs(root, null, null);
        return result;
    }

    private void dfs(TreeNode root, TreeNode parent, TreeNode grandparent) {
        if (root == null) {
            return;
        }
        if (parent == null) {
            dfs(root.left, root, null);
            dfs(root.right, root, null);
            return;
        }
        if (grandparent != null && grandparent.val % 2 == 0) {
            result += root.val;
        }
        dfs(root.left, root, parent);
        dfs(root.right, root, parent);
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5});
        System.out.println((new Problem1315()).sumEvenGrandparent(root));
    }
}
