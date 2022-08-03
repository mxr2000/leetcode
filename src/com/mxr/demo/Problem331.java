package com.mxr.demo;

public class Problem331 {
    private int index;
    public boolean isValidSerialization(String preorder) {
        index = 0;
        String[] parts = preorder.split(",");
        return isValid(parts) && index == parts.length;
    }
    private boolean isValid(String[] parts) {
        if (index >= parts.length) {
            return false;
        }
        if (parts[index].equals("#")) {
            index++;
            return true;
        }
        index++;
        return isValid(parts) && isValid(parts);
    }

    public static void main(String[] args) {
        System.out.println((new Problem331()).isValidSerialization("9,#,#,1"));
    }
}
