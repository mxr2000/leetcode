package com.mxr.demo;

public class Problem243 {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int index1 = Integer.MIN_VALUE;
        int index2 = Integer.MIN_VALUE;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];
            if (word.equals(word1)) {
                index1 = i;
                if (index2 < 0) {
                    continue;
                }
                int distance = index1 - index2;
                if (distance < minDistance) {
                    minDistance = distance;
                }
            }
            if (word.equals(word2)) {
                index2 = i;
                if (index1 < 0) {
                    continue;
                }
                int distance = index2 - index1;
                if (distance < minDistance) {
                    minDistance = distance;
                }
            }
        }
        return minDistance;
    }

    public static void main(String[] args) {
        String[] dict = {"practice", "makes", "perfect", "coding", "makes"};
        System.out.println((new Problem243()).shortestDistance(dict, "makes", "coding"));
    }
}
