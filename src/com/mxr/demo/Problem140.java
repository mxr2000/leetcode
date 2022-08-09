package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem140 {
    static class Node {
        Node[] children = new Node[26];
        boolean endHere;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Node head = buildTrie(wordDict);
        List<String> results = new ArrayList<>();
        backtrack(results, new ArrayList<>(), s, 0, head);
        return results;
    }

    private void backtrack(List<String> results, List<String> list, String s, int from, Node head) {
        if (from == s.length()) {
            results.add(String.join(" ", list));
            return;
        }
        int cur = from;
        Node node = head;
        while (cur != s.length() && node != null && node.children[s.charAt(cur) - 'a'] != null) {
            node = node.children[s.charAt(cur) - 'a'];
            if (node.endHere) {
                list.add(s.substring(from, cur + 1));
                backtrack(results, list, s, cur + 1, head);
                list.remove(list.size() - 1);
            }
            ++cur;
        }
    }

    private Node buildTrie(List<String> wordDict) {
        Node head = new Node();
        for (String word : wordDict) {
            Node cur = head;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (cur.children[index] == null) {
                    cur.children[index] = new Node();
                }
                cur = cur.children[index];
            }
            cur.endHere = true;
        }
        return head;
    }

    public static void main(String[] args) {
        String s = "pineapplepenapple";
        List<String> dict = List.of("apple","pen","applepen","pine","pineapple");
        System.out.println((new Problem140()).wordBreak(s, dict));
    }
}
