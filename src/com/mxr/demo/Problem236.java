package com.mxr.demo;

public class Problem236 {
    TreeNode first;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        found(root, p.val, q.val);
        return first;
    }

    int found(TreeNode root, int val1, int val2) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        if (root.val == val1 || root.val == val2) {
            ++result;
        }
        result += found(root.left, val1, val2);
        result += found(root.right, val1, val2);
        if (result == 2 && first == null) {
            first = root;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        System.out.println((new Problem236()).lowestCommonAncestor(root, root.left, root.right).val);
    }
}
