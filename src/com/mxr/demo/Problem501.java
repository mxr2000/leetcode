package com.mxr.demo;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem501 {
    private int maxMode = 0;
    private Set<Integer> set = new HashSet<>();

    public int[] findMode(TreeNode root) {
        process(root, null, 0);
        int[] results = new int[set.size()];
        int index = 0;
        for (int val : set) {
            results[index++] = val;
        }
        return results;
    }

    private void process(TreeNode root, Integer parentVal, int currentMode) {
        if (root == null) {
            reset(parentVal, currentMode);
            return;
        }
        if (parentVal == null) {
            process(root.left, root.val, 1);
            process(root.right, root.val, 1);
            return;
        }
        if (root.val != parentVal) {
            reset(parentVal, currentMode);
            process(root.left, root.val, 1);
            process(root.right, root.val, 1);
        } else {
            process(root.left, parentVal, currentMode + 1);
            process(root.right, parentVal, currentMode + 1);
        }
    }

    private void reset(int value, int mode) {
        if (mode == maxMode) {
            set.add(value);
        } else if (mode > maxMode) {
            set.clear();
            maxMode = mode;
            set.add(value);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{1, null, 2, 2});
        int[] modes = (new Problem501()).findMode(root);
        for (int val : modes) {
            System.out.println(val);
        }

    }
}
