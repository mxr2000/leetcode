package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem662 {
    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 0, 1, new ArrayList<>(), new ArrayList<>());
    }

    int dfs(TreeNode root, int level, int order, List<Integer> left, List<Integer> right) {
        if (root == null) {
            return 0;
        }
        if (left.size() == level) {
            left.add(order);
            right.add(order);
        } else {
            right.set(level, order);
        }
        int cur = right.get(level) - left.get(level) + 1;
        int l = dfs(root.left, level + 1, 2 * order, left, right);
        int r = dfs(root.right, level + 1, 2 * order + 1, left, right);
        return Math.max(cur, Math.max(l, r));
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{1,3,2,5,null,null,9,6,null,7});
        System.out.println((new Problem662()).widthOfBinaryTree(root));
    }
}
