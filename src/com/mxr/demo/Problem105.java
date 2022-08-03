package com.mxr.demo;

import java.util.HashMap;
import java.util.Map;

public class Problem105 {
    private int pIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(map, preorder, 0, preorder.length);
    }
    private TreeNode build(Map<Integer, Integer> map, int[] preorder, int from, int to) {
        if (from >= to) {
            return null;
        }
        if (pIndex >= preorder.length) {
            return null;
        }
        int value = preorder[pIndex];
        pIndex++;
        TreeNode root = new TreeNode(value);

        root.left = build(map, preorder, from, map.get(value));
        root.right = build(map, preorder, map.get(value) + 1, to);
        return root;
    }
}
