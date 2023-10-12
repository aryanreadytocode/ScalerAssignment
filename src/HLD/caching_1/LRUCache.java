package HLD.caching_1;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Node head, tail;
    int capacity;
    Map<Integer, Node> map;

    class Node {
        Node next;
        Node prev;
        int key, value;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node n = map.get(key);
        if (map.containsKey(key)) {
            remove(n);
            insert(n);
            return n.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        Node n = map.get(key);
        if (map.containsKey(key)) {
            remove(n);
        }
        if (map.size() == capacity){
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }

    private void insert(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
