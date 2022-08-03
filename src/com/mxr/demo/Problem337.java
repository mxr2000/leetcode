package com.mxr.demo;

import java.util.HashMap;
import java.util.Map;

public class Problem337 {
    private Map<TreeNode, Integer> dp;

    public int rob(TreeNode root) {
        dp = new HashMap<>();
        dfs(root);
        return dp.get(root);
    }

    private int dfs(TreeNode current) {
        if (current == null) {
            return 0;
        }
        if (dp.containsKey(current)) {
            return dp.get(current);
        }
        int subSubMax = 0;
        if (current.left != null) {
            subSubMax += (dfs(current.left.left) + dfs(current.left.right));
        }
        if (current.right != null) {
            subSubMax += (dfs(current.right.left) + dfs(current.right.right));
        }
        int max = Math.max(dfs(current.left) + dfs(current.right), subSubMax + current.val);
        dp.put(current, max);
        return max;
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{3, 2, 3, null, 3, null, 1});
        System.out.println((new Problem337()).rob(root));
    }
}
