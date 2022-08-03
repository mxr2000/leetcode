package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem1469 {
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(result, root, 0);
        return result;
    }

    private void dfs(List<Integer> result, TreeNode root, int parentChildCnt) {
        if (root == null) {
            return;
        }
        if (parentChildCnt == 1) {
            result.add(root.val);
        }
        int cnt = 0;
        cnt += (root.left == null ? 0 : 1);
        cnt += (root.right == null ? 0 : 1);
        dfs(result, root.left, cnt);
        dfs(result, root.right, cnt);
    }
}
