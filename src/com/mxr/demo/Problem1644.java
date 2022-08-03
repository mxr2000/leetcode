package com.mxr.demo;

public class Problem1644 {
    private TreeNode result = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p.val, q.val);
        return result;
    }

    private int dfs(TreeNode root, int v1, int v2) {
        if (root == null) {
            return 0;
        }
        if (result != null) {
            return 0;
        }
        int left = dfs(root.left, v1, v2);
        int right = dfs(root.right, v1, v2);
        if ((left == 1 || root.val == v1) && right == 2) {
            result = root;
            return 0;
        }
        if ((left == 2 || root.val == v2) && right == 1) {
            result = root;
            return 0;
        }
        if ((right == 1 || root.val == v1) && left == 2) {
            result = root;
            return 0;
        }
        if ((right == 2 || root.val == v2) && left == 1) {
            result = root;
            return 0;
        }
        return left != 0 ? left : right != 0 ? right : root.val == v1 ? 1 : root.val == v2 ? 2 : 0;
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        TreeNode p = new TreeNode();
        TreeNode q = new TreeNode();
        p.val = 5;
        q.val = 4;
        System.out.println(new Problem1644().lowestCommonAncestor(root, p, q).val);
    }
}
