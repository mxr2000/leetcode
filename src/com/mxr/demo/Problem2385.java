package com.mxr.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem2385 {
    TreeNode startNode = null;

    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParent(parentMap, root, start);
        if (startNode == null) {
            return 0;
        }
        int result = 0;
        List<TreeNode> list = new ArrayList<>();
        list.add(startNode);
        startNode.val = 0;
        while (!list.isEmpty()) {
            List<TreeNode> newList = new ArrayList<>();
            for (TreeNode node : list) {
                if (node.left != null && node.left.val != 0) {
                    node.left.val = 0;
                    newList.add(node.left);
                }
                if (node.right != null && node.right.val != 0) {
                    node.right.val = 0;
                    newList.add(node.right);
                }
                if (parentMap.containsKey(node) && parentMap.get(node).val != 0) {
                    parentMap.get(node).val = 0;
                    newList.add(parentMap.get(node));
                }
            }
            if (!newList.isEmpty()) {
                ++result;
            }
            list = newList;
        }

        return result;
    }

    private void buildParent(Map<TreeNode, TreeNode> parentMap, TreeNode root, int val) {
        if (root == null) {
            return;
        }
        if (root.val == val) {
            startNode = root;
        }
        if (root.left != null) {
            parentMap.put(root.left, root);
            buildParent(parentMap, root.left, val);
        }
        if (root.right != null) {
            parentMap.put(root.right, root);
            buildParent(parentMap, root.right, val);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{1, 5, 3, null, 4, 10, 6, 9, 2});
        System.out.println((new Problem2385()).amountOfTime(root, 3));
    }
}
