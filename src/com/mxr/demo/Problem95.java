package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem95 {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[][] dp = new List[n][n];
        return process(1, n);
    }

    private List<TreeNode> process(int begin, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (begin > end) {
            list.add(null);
        }
        for (int i = begin; i <= end; i++) {
            List<TreeNode> leftList = process(begin, i - 1);
            List<TreeNode> rightList = process(i + 1, end);
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }

    List<TreeNode> get(List<TreeNode>[][] dp, int from, int to) {
        if (to < from) {
            return null;
        }
        return dp[from - 1][to - 1];
    }
    void put(List<TreeNode>[][] dp, int from, int to, List<TreeNode> list) {
        dp[from - 1][to - 1] = list;
    }

    public static void main(String[] args) {
        System.out.println((new Problem95()).generateTrees(3));
    }
}
