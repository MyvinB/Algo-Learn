package practise;

import java.util.HashMap;

public class LC146LRU {
    class LRUCache {

        Node head = new Node();
        Node tail = new Node();
        HashMap<Integer,Node> map;
        int capacity;
        class Node{
            int val;
            int key;
            Node prev;
            Node next;
        }

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map= new HashMap<>();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            Node node = map.get(key);
            if(node==null) return -1;
            remove(node);
            add(node);
            return node.val;
        }

        public void add(Node node){
            Node head_next = head.next;
            head.next = node;
            node.prev = head;
            node.next = head_next;
            head_next.prev = node;
        }

        public void remove(Node node){
            Node next = node.next;
            Node prev = node.prev;
            prev.next = next;
            next.prev = prev;
        }



        public void put(int key, int value) {
            if(map.containsKey(key)){
                Node node = map.get(key);
                node.val = value;
                remove(node);
                add(node);
            }else{
                if(map.size()== capacity){
                    map.remove(tail.prev.key);
                    remove(tail.prev);
                }
                Node newNode = new Node();
                newNode.val = value;
                newNode.key = key;
                add(newNode);
                map.put(key,newNode);
            }
        }
    }
}
