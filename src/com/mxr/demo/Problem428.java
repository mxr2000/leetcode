package com.mxr.demo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Problem428 {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    static class Codec {
        // Encodes a tree to a single string.
        public String serialize(Node root) {
            if (root == null) {
                return "";
            }
            StringBuilder builder = new StringBuilder();
            builder.append(root.val);
            builder.append(" ");
            builder.append(root.children.size());
            builder.append(" ");
            for (Node child : root.children) {
                builder.append(serialize(child));
            }
            return builder.toString();
        }

        // Decodes your encoded data to tree.
        public Node deserialize(String data) {
            List<Integer> nums = Arrays.stream(data.split(" ")).filter(str -> !"".equals(str)).map(Integer::parseInt).toList();
            return nums.size() == 0 ? null : (Node) deserialize(nums, 0)[0];
        }

        private Object[] deserialize(List<Integer> nums, int from) {
            int val = nums.get(from);
            int cnt = nums.get(from + 1);
            int begin = from + 2;
            List<Node> children = new LinkedList<>();
            for (int i = 0; i < cnt; i++) {
                Object[] rets = deserialize(nums, begin);
                Node child = (Node) rets[0];
                int length = (Integer) rets[1];
                children.add(child);
                begin += length;
            }
            Node root = new Node();
            root.val = val;
            root.children = children;
            return new Object[] {root, begin - from};
        }
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        Node node = codec.deserialize("");
        Node root = codec.deserialize("1 3 3 2 5 0 6 0 2 0 4 0 ");
        String str = codec.serialize(root);
        System.out.println(codec.deserialize(str));
    }
}
