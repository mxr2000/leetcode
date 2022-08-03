package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem513 {
    public int findBottomLeftValue(TreeNode root) {
        TreeNode target = null;
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()) {
            target = list.get(0);
            List<TreeNode> newList = new ArrayList<>();
            for (TreeNode node : list) {
                if (node.left != null) {
                    newList.add(node.left);
                }
                if (node.right != null) {
                    newList.add(node.right);
                }
            }
            list = newList;
        }
        return target.val;
    }
}
