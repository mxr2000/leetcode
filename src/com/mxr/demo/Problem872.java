package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        dfs(l1, root1);
        dfs(l2, root2);
        if (l1.size() != l2.size()) {
            return false;
        }
        for (int i = 0; i < l1.size(); ++i) {
            if (l1.get(i) != l2.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void dfs(List<Integer> leaves, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
            return;
        }
        dfs(leaves, root.left);
        dfs(leaves, root.right);
    }
}
