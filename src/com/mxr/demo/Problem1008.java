package com.mxr.demo;

public class Problem1008 {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, 0, preorder.length);
    }

    public TreeNode bstFromPreorder(int[] preorder, int from, int to) {
        if (to <= from) {
            return null;
        }
        TreeNode root = new TreeNode();
        root.val = preorder[from];
        int newForm = from + 1;
        for (; newForm < to; newForm++) {
            if (preorder[newForm] > root.val) {
                break;
            }
        }
        root.left = bstFromPreorder(preorder, from + 1, newForm);
        root.right = bstFromPreorder(preorder, newForm, to);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {8, 5, 1, 7, 10, 12};
        TreeNode root = (new Problem1008()).bstFromPreorder(preorder);
        System.out.println(root);
    }
}
