package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {
    List<Integer> list = new ArrayList<>();
    int cur = -1;
    public BSTIterator(TreeNode root) {
        dfs(root);
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }

    public boolean hasNext() {
        return cur < list.size() - 1;
    }

    public int next() {
        ++cur;
        System.out.println(cur);
        return list.get(cur);
    }

    public boolean hasPrev() {
        return cur > 0;
    }

    public int prev() {
        --cur;
        return list.get(cur);
    }
}
