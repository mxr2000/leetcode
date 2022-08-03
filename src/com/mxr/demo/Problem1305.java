package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        List<Integer> result = new ArrayList<>();

        while (root1 != null || root2 != null || !s1.isEmpty() || !s2.isEmpty()) {
            while (root1 != null) {
                s1.push(root1);
                root1 = root1.left;
            }
            while (root2 != null) {
                s2.push(root2);
                root2 = root2.left;
            }
            if (s2.isEmpty() || (!s1.isEmpty() && s1.peek().val <= s2.peek().val)) {
                root1 = s1.pop();
                result.add(root1.val);
                root1 = root1.right;
            } else {
                root2 = s2.pop();
                result.add(root2.val);
                root2 = root2.right;
            }
        }

        return result;
    }



    public static void main(String[] args) {
        TreeNode root1 = TreeGenerator.generate(new Integer[] {2, 1});

    }
}
