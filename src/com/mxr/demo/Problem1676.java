package com.mxr.demo;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem1676 {
    private TreeNode result = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<Integer> targets = Arrays.stream(nodes).map(n -> n.val).collect(Collectors.toSet());
        dfs(root, targets);
        return result;
    }

    private int dfs(TreeNode root, Set<Integer> targets) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, targets);
        int right = dfs(root.right, targets);
        int sum = left + right + (targets.contains(root.val) ? 1 : 0);
        if (result == null && sum == targets.size()) {
            result = root;
        }
        return sum;
    }
}
