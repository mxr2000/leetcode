package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem863 {
    List<Integer> results = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfs(root, target.val, k);
        return results;
    }

    private int dfs(TreeNode root, int target, int k) {
        if (root == null) {
            return 0;
        }
        if (root.val == target) {
            findChildResult(root, k);
            return 1;
        }
        TreeNode child = null;
        int result = dfs(root.left, target, k);
        if (result != 0) {
            child = root.right;
        } else if ((result = dfs(root.right, target, k)) != 0) {
            child = root.left;
        }
        if (result == 0) {
            return 0;
        }
        if (result == k) {
            results.add(root.val);
        } else if (child != null) {
            findChildResult(child, k - result - 1);
        }
        return result + 1;
    }

    private void findChildResult(TreeNode root, int distance) {
        if (root == null) {
            return;
        }
        if (distance == 0) {
            results.add(root.val);
            return;
        }
        findChildResult(root.left, distance - 1);
        findChildResult(root.right, distance - 1);
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{0, null, 1, 3, 2, null, null, 4, null, null, 5});
        System.out.println((new Problem863()).distanceK(root, new TreeNode(4), 0));
    }
}
