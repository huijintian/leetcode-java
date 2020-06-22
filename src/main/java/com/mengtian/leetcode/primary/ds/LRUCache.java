package com.mengtian.leetcode.primary.ds;

import java.util.HashMap;

/**
 * Created by mengtian on 2020/6/11
 */
public class LRUCache {
    class Node {
        private String key;
        private String value;
        private Node pre;
        private Node next;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node head;
    private Node end;
    private int limit;

    private HashMap<String, Node> hashMap;

    public LRUCache(int limit) {
        this.limit = limit;
        hashMap = new HashMap<>();
    }

    public String get(String key) {
        Node node = hashMap.get(key);
        if (node == null) {
            return null;
        }
        refreshNode(node);
        return node.value;
    }

    public void put(String key, String value) {
        Node node = hashMap.get(key);
        if (node == null) {
            if (hashMap.size() >= limit) {
                String oldKey = removeNode(head);
                hashMap.remove(oldKey);
            }
            node = new Node(key, value);
            addNode(node);
            hashMap.put(key, node);
        } else {
            node.value = value;
            refreshNode(node);
        }
    }

    public void remove(String key) {
        Node node = hashMap.get(key);
        removeNode(node);
        hashMap.remove(key);
    }

    private void refreshNode(Node node) {
        if (node == end) {
            return;
        }
        removeNode(node);
        addNode(node);
    }

    private String removeNode(Node node) {
        if (node == head && node == end) {
            head = null;
            end = null;
        } else if (node == end) {
            end = end.pre;
            end.next = null;
        } else if (node == head) {
            head = head.next;
            head.pre = null;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        return node.key;
    }

    private void addNode(Node node) {
        if (end != null) {
            end.next = node;
            node.pre = end;
            node.next = null;
        }
        end = node;
        if (head == null) {
            head = node;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);
        lruCache.put("1", "用户1信息");
        lruCache.put("2", "用户1信息");
        lruCache.put("3", "用户1信息");
        lruCache.put("4", "用户1信息");
        lruCache.put("5", "用户1信息");
        lruCache.get("2");
        lruCache.put("4", "用户4信息");
        lruCache.put("6", "用户6信息");
        System.out.println(lruCache.get("1"));
        System.out.println(lruCache.get("6"));
    }
}
