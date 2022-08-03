package com.mxr.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> results = new ArrayList<>();
        precess(results, new ArrayList<>(), root, targetSum);
        return results;
    }
    public void precess(List<List<Integer>> results, List<Integer> path, TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        if (root.val == targetSum && root.left == null && root.right == null) {
            path.add(targetSum);
            results.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        path.add(root.val);
        precess(results, path, root.left, targetSum - root.val);
        precess(results, path, root.right, targetSum - root.val);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1});
        System.out.println((new Problem113()).pathSum(root, 22));
    }
}
