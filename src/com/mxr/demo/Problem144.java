package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(list, root);
        return list;
    }
    private void traverse(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        traverse(list, root.left);
        traverse(list, root.right);
    }
}
