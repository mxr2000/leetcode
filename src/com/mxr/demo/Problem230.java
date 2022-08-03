package com.mxr.demo;

import java.util.Stack;

public class Problem230 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty()) {
                continue;
            }
            --k;
            if (k == 0) {
                return stack.peek().val;
            } else {
                root = stack.pop().right;
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{5, 3, 6, 2, 4, null, null, 1});
        System.out.println((new Problem230()).kthSmallest(root, 3));
    }
}
