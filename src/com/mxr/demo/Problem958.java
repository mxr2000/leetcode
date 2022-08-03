package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem958 {
    private int shouldDepth = 0;
    private boolean hasChanged = false;

    public boolean isCompleteTree(TreeNode root) {
        return dfs(root, 0);
    }

    private boolean dfs(TreeNode root, int upDepth) {
        if (root == null) {
            if (shouldDepth == 0) {
                shouldDepth = upDepth;
                return true;
            } else if (upDepth == shouldDepth) {
                return true;
            } else if (!hasChanged && upDepth == shouldDepth - 1) {
                shouldDepth = upDepth;
                hasChanged = true;
                return true;
            } else {
                return false;
            }
        }
        return dfs(root.left, upDepth + 1) && dfs(root.right, upDepth + 1);
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, null, null, 15})
        ;
        System.out.println((new Problem958()).isCompleteTree(root));
    }
}
