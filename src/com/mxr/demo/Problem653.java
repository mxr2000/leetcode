package com.mxr.demo;

import java.util.HashSet;
import java.util.Set;

public class Problem653 {
    private final Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);

        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
