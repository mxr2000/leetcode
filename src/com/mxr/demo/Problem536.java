package com.mxr.demo;

import java.util.Stack;

public class Problem536 {
    public TreeNode str2tree(String s) {
        Stack<TreeNode> stack = new Stack<>();
        int index = 0;
        char[] arr = s.toCharArray();
        while (index < arr.length) {
            char ch = arr[index];
            if (ch == ')') {
                stack.pop();
                ++index;
            } else if (isValidNUmberPart(ch)) {
                int[] ret = nextNum(arr, index);
                TreeNode cur = new TreeNode(ret[0]);
                if (!stack.isEmpty()) {
                    TreeNode parent = stack.peek();
                    if (parent.left != null) {
                        parent.right = cur;
                    } else {
                        parent.left = cur;
                    }
                }
                stack.push(cur);
                index = ret[1];
            } else {
                ++index;
            }
        }
        return stack.isEmpty() ? null : stack.pop();
    }

    private int[] nextNum(char[] arr, int index) {
        boolean signed = false;
        int result = 0;
        while (index < arr.length && isValidNUmberPart(arr[index])) {
            if (arr[index] == '-') {
                signed = true;
            } else {
                result = 10 * result + (arr[index] - '0');
            }
            ++index;
        }
        return new int[] {signed ? -result : result, index};
    }

    private boolean isValidNUmberPart(char ch) {
        return ch == '-' || (ch >= '0' && ch <= '9');
    }

    public static void main(String[] args) {
        String s = "4(2(3)(1))(6(5))";
        System.out.println((new Problem536()).str2tree(s));
    }
}
