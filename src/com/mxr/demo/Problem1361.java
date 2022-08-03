package com.mxr.demo;

import java.util.HashSet;
import java.util.Set;

public class Problem1361 {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        boolean[] visited = new boolean[n];
        Set<Integer> rootSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            rootSet.add(i);
        }
        for (int i = 0; i < n; i++) {
            rootSet.remove(leftChild[i]);
            rootSet.remove(rightChild[i]);
        }
        if (rootSet.size() != 1) {
            return false;
        }

        if (!dfs(visited, rootSet.iterator().next(), leftChild, rightChild)) {
            return false;
        }
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(boolean[] visited, int current, int[] leftChild, int[] rightChild) {
        visited[current] = true;
        int left = leftChild[current];
        int right = rightChild[current];
        return (left == -1 || (!visited[left] && dfs(visited, left, leftChild, rightChild))) && (right == -1 || (!visited[right] && dfs(visited, right, leftChild, rightChild)));
    }

    public static void main(String[] args) {
        int[] leftChild = {1, -1, 3, -1};
        int[] rightChild = {2, -1, -1, -1};
        System.out.println((new Problem1361()).validateBinaryTreeNodes(4, leftChild, rightChild));
    }
}
