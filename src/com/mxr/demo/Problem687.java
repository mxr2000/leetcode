package com.mxr.demo;

import java.util.HashMap;
import java.util.Map;

public class Problem687 {
    private Map<TreeNode, Integer> dp = new HashMap<>();
    private int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max == 0 ? 0 : max - 1;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (dp.containsKey(root)) {
            return dp.get(root);
        }
        int val = 1;
        int sum = 1;
        int leftCnt = dfs(root.left);
        int rightCount = dfs(root.right);

        if (root.left != null && root.left.val == root.val) {
            val = Math.max(val, leftCnt + 1);
            sum += leftCnt;
        }
        if (root.right != null && root.right.val == root.val) {
            val = Math.max(val, rightCount + 1);
            sum += rightCount;
        }

        dp.put(root, val);
        max = Math.max(max, sum);
        return val;
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{1, null, 1, 1, 1, 1, 1, 1});
        System.out.println((new Problem687()).longestUnivaluePath(root));
    }
}
