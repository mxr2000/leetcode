package com.mxr.demo;

public class Problem1038 {
    public TreeNode bstToGst(TreeNode root) {
        dfs(root, 0);
        return root;
    }

    private int dfs(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }
        int rightMax = dfs(root.right, sum);
        root.val += rightMax;
        if (root.left != null) {
            return dfs(root.left, root.val);
        }
        return root.val;
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8});
        TreeNode node = (new Problem1038()).bstToGst(root);
        System.out.println(node);
    }
}
