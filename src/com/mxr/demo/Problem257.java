package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> results = new ArrayList<>();
        process(results, "", root);
        return results;
    }

    private void process(List<String> results, String result, TreeNode root) {
        if (root == null) {
            return;
        }
        if (!result.equals("")) {
            result += "->";
        }
        result += root.val;
        if (root.left == null && root.right == null) {
            results.add(result);
        } else {
            process(results, result, root.left);
            process(results, result, root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeGenerator.generate(new Integer[]{1,2,3,null,5});
        System.out.println((new Problem257()).binaryTreePaths(root));
    }
}
