package com.mxr.demo;

public class Problem988 {
    public String smallestFromLeaf(TreeNode root) {
        if (root == null) {
            return "";
        }
        String left = smallestFromLeaf(root.left);
        String right = smallestFromLeaf(root.right);
        if ("".equals(left)) {
            return right + (char) ('a' + root.val);
        } else if ("".equals(right)) {
            return left + (char) ('a' + root.val);
        }
        return (left.compareTo(right) < 0 ? left : right) + (char) ('a' + root.val);
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{4, 0, 1, 1});
        System.out.println((new Problem988()).smallestFromLeaf(root));
    }
}
