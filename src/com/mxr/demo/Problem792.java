package com.mxr.demo;

import java.util.ArrayList;
import java.util.List;

public class Problem792 {
    static class Node {
        String word;
        int index;

        public Node(String word, int index) {
            this.word = word;
            this.index = index;
        }
    }
    public int numMatchingSubseq(String s, String[] words) {
        int result = 0;
        List<Node>[] heads = new List[26];
        for (int i = 0; i < 26; i++) {
            heads[i] = new ArrayList<>();
        }

        for (String word : words) {
            heads[word.charAt(0) - 'a'].add(new Node(word, 0));
        }
        for (char ch : s.toCharArray()) {
            List<Node> oldBucket = heads[ch - 'a'];
            heads[ch - 'a'] = new ArrayList<>();
            for (Node node : oldBucket) {
                node.index++;
                if (node.index == node.word.length()) {
                    ++result;
                } else {
                    heads[node.word.charAt(node.index) - 'a'].add(node);
                }
            }
            oldBucket.clear();
        }
        return result;
    }
}
