package com.mxr.demo;

import java.util.*;

public class Problem133 {
    public Node cloneGraph(Node node) {
        Map<Integer, Node> map = new HashMap<>();
        return clone(map, node);
    }
    private Node clone(Map<Integer, Node> map, Node node) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        Node copied = new Node(node.val);
        map.put(copied.val, copied);
        for (Node neighbour : node.neighbors) {
            copied.neighbors.add(clone(map, neighbour));
        }
        return copied;
    }
}
