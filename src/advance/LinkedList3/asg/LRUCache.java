package advance.LinkedList3.asg;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    /*
    * capacity = 2
         set(1, 10)
         set(5, 12)
         get(5)        returns 12
         get(1)        returns 10
         get(10)       returns -1
         set(6, 14)    this pushes out key = 5 as LRU is full.
         get(5)        returns -1 */
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);
        /*2 1 S 2 2 G 2 S 1 1 S 4 1 G 2
         */
        lruCache.set(2, 1);
        lruCache.print();
        lruCache.set(2, 2);
        lruCache.print();
        System.out.println(lruCache.get(2));
        lruCache.set(1, 1);
        lruCache.print();
        lruCache.set(4, 1);
        lruCache.print();
        System.out.println(lruCache.get(2));
        /*System.out.println(lruCache.get(5));
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(10));
        lruCache.set(6,16);
        lruCache.print();
        lruCache.set(6,16);
        lruCache.print();
        lruCache.set(3,13);
        lruCache.print();
        System.out.println(lruCache.get(5));*/
    }


    public void print() {
        Node temp = head;
        while (temp != null) {
            String print = temp.next != null ? temp.key + " " + temp.value + ">>" : temp.key + " " + temp.value + "\n";
            System.out.print(print);
            temp = temp.next;
        }
    }



    Node head = new Node(0, 0), tail = new Node(0, 0);
    Map< Integer, Node > map = new HashMap();
    int capacity;

    public LRUCache(int _capacity) {
        capacity = _capacity;
        head.next = tail;
        tail.prev = head;
    }


    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        } else {
            return -1;
        }

    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == capacity) {
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    class Node {
        Node prev, next;
        int key, value;
        Node(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

}
