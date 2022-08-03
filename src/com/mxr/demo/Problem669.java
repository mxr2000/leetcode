package com.mxr.demo;

public class Problem669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{3, 0, 4, null, 2, null, null, 1});
        root = (new Problem669()).trimBST(root, 1, 3);
        System.out.println(root);
    }
}
