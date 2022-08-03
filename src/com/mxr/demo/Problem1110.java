package com.mxr.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem1110 {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : to_delete) {
            set.add(num);
        }
        root = dfs(result, set, root);
        if (root != null) {
            result.add(root);
        }
        return result;
    }

    private TreeNode dfs(List<TreeNode> result, Set<Integer> set, TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = dfs(result, set, root.left);
        root.right = dfs(result, set, root.right);
        if (set.contains(root.val)) {
            if (root.left != null) {
                result.add(root.left);
            }
            if (root.right != null) {
                result.add(root.right);
            }
            return null;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        int[] to_delete = {3, 5};
        System.out.println((new Problem1110()).delNodes(root, to_delete));
    }
}
