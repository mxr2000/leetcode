package com.mxr.demo;

public class Problem222 {
    int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + height(node.left);

    }
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = height(root);
        if (height(root.right) == height - 1) {
            return (1 << (height - 1)) + countNodes(root.right);
        } else {
            System.out.println(1 << (height - 2));
            return (1 << (height - 2)) + countNodes(root.left);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{1, 2, 3, 4, 5, 6});
        System.out.println((new Problem222()).countNodes(root));
    }
}
