package com.mxr.demo;

public class Problem298 {
    private int result = 0;

    public int longestConsecutive(TreeNode root) {
        dfs(root, null, 0);
        return result;
    }

    private void dfs(TreeNode root, TreeNode parent, int length) {
        if (root == null) {
            result = Math.max(result, length);
            return;
        }
        if (parent == null || root.val != parent.val + 1) {
            result = Math.max(result, length);
            dfs(root.left, root, 1);
            dfs(root.right, root, 1);
            return;
        }
        dfs(root.left, root, length + 1);
        dfs(root.right, root, length + 1);
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{1, 2, 3, 4, 5});
        System.out.println((new Problem298()).longestConsecutive(root));
    }
}
