package com.mxr.demo;

import java.util.HashMap;
import java.util.Map;

public class Problem538 {
    private final Map<TreeNode, Integer> dp = new HashMap<>();

    public TreeNode convertBST(TreeNode root) {
        return convert(root, 0);
    }

    private TreeNode convert(TreeNode root, int rootLargerValue) {
        if (root == null) {
            return null;
        }
        TreeNode node = new TreeNode();
        node.val = rootLargerValue + getChildrenSum(root.right) + root.val;
        node.right = convert(root.right, rootLargerValue);
        node.left = convert(root.left, node.val);
        return node;
    }

    private int getChildrenSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (dp.containsKey(root)) {
            return dp.get(root);
        }
        int val = root.val + getChildrenSum(root.left) + getChildrenSum(root.right);
        dp.put(root, val);
        return val;
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8});
        TreeNode node = (new Problem538()).convertBST(root);
        System.out.println(node);
    }
}
