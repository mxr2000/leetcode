package com.mxr.demo;

public class Problem255 {
    public boolean verifyPreorder(int[] preorder) {
        return verify(preorder, 0, preorder.length, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean verify(int[] preorder, int from, int to, int min, int max) {
        if (to <= from + 1) {
            return true;
        }
        for (int i = from; i < to; i++) {
            if (preorder[i] <= min || preorder[i] >= max) {
                return false;
            }
        }
        int index = from + 1;
        while (index < to) {
            if (preorder[index] > preorder[from]) {
                break;
            }
            ++index;
        }
        return verify(preorder, from + 1, index, min, preorder[from]) && (index >= to || verify(preorder, index, to, preorder[from], max));
    }

    public static void main(String[] args) {
        int[] preorder = {5,2,6,1,3};
        System.out.println((new Problem255().verifyPreorder(preorder)));
    }
}
