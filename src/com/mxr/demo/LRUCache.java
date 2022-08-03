package com.mxr.demo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    static class Node {
        Node pre, next;
        int value;
        int key;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private final Map<Integer, Node> map = new HashMap<>();
    private Node leastUsedNode, mostUsedNode;
    private final int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key).value;
        if (leastUsedNode == mostUsedNode) {
            return val;
        }
        Node node = map.get(key);
        if (node.pre == null) {
            Node newHead = leastUsedNode.next;
            node.pre = mostUsedNode;
            mostUsedNode.next = node;
            mostUsedNode = node;
            node.next = null;
            leastUsedNode = newHead;
            newHead.pre = null;
        } else if (node.next == null) {
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            mostUsedNode.next = node;
            mostUsedNode = node;
            node.next = null;
        }
        return val;
    }


    public void put(int key, int value) {

        Node node = new Node(key, value);
        if (leastUsedNode == null) {
            leastUsedNode = mostUsedNode = node;
        } else {
            mostUsedNode.next = node;
            node.pre = mostUsedNode;
            mostUsedNode = node;
        }
        boolean update = map.containsKey(key);
        int newSize = map.size() + 1;
        map.put(key, node);
        if (newSize > capacity) {
            if (!update) {
                map.remove(leastUsedNode.key);
            }
            leastUsedNode = leastUsedNode.next;
            leastUsedNode.pre = null;
        }
    }

    private void printList() {
        System.out.print("[");
        Node node = leastUsedNode;
        while (mostUsedNode != null) {
            System.out.print("" + leastUsedNode.key + ", ");
        }
        System.out.print("]");
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(2, 1);
        lRUCache.put(1, 1);
        lRUCache.put(2, 3);
        lRUCache.put(4, 1);
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(2));
    }
}

/**
 * 2
 * 2 1
 * 2 1
 * 2 4
 */
