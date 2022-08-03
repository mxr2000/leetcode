package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem1268 {

    static class Node {
        public final boolean terminated;
        public Node[] children = new Node[26];

        public Node(boolean terminated) {
            this.terminated = terminated;
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> results = new ArrayList<>();
        Node[] roots = new Node[26];
        for (String word : products) {
            addToTree(roots, word);
        }
        for (int i = 1; i <= searchWord.length(); i++) {
            addToResult(results, roots, searchWord.substring(0, i));
        }
        return results;
    }

    private void addToTree(Node[] roots, String word) {
        Node root = roots[word.charAt(0) - 'a'];
        if (root == null) {
            root = roots[word.charAt(0) - 'a'] = new Node(false);
        }
        for (int i = 1; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (root.children[ch - 'a'] == null) {
                root.children[ch - 'a'] = new Node(i == word.length() - 1);
            }
            root = root.children[ch - 'a'];
        }
    }

    private void addToResult(List<List<String>> results, Node[] roots, String slice) {
        Node root = roots[slice.charAt(0) - 'a'];
        if (root == null) {
            results.add(new ArrayList<>());
            return;
        }
        StringBuilder path = new StringBuilder("" + slice.charAt(0));
        for (int i = 1; i < slice.length(); i++) {
            char ch = slice.charAt(i);
            path.append(ch);
            root = root.children[ch - 'a'];
            if (root == null) {
                results.add(new ArrayList<>());
                return;
            }
        }
        List<String> result = new ArrayList<>();
        addToResult(result, path.toString(), root);
        results.add(result.stream().limit(3).collect(Collectors.toList()));
    }

    private void addToResult(List<String> result, String path, Node root) {

        if (root.terminated) {
            result.add(path);
        }
        for (int i = 0; i < root.children.length; i++) {
            Node child = root.children[i];
            if (child == null) {
                continue;
            }
            addToResult(result, path + (char) ('a' + i), child);
        }
    }

    public static void main(String[] args) {
        String[] products = {
                "havana"
        };
        List<List<String>> results = (new Problem1268()).suggestedProducts(products, "tatiana");
        System.out.println(results);
    }
}
