package LeetCodeChallenge.Aug2022.GPRevision;

import java.util.HashMap;

public class LC146 {

    class LRUCache {
        Node head;
        Node tail;
        HashMap<Integer,Node> map;
        int capacity;
        class Node{
            int key;
            int value;
            Node next;
            Node prev;
        }

        public LRUCache(int capacity) {
             this.capacity = capacity;
             head= new Node();
             tail = new Node();
             head.next = tail;
             tail.prev = head;
             map = new HashMap<>();
        }

        public int get(int key) {
            if(!map.containsKey(key)) return -1;
            Node temp = map.get(key);
            removeNode(temp);
            addNode(temp);
            return temp.value;
        }

        public void put(int key, int value) {
            if(map.containsKey(key)){
                Node temp = map.get(key);
                temp.value = value;
                removeNode(temp);
                addNode(temp);
            }else {
                if(map.size()==capacity){
                    //remove last node
                    Node lastNode = tail.prev;
                    map.remove(lastNode.key);
                    removeNode(lastNode);
                }
                Node temp = new Node();
                temp.value = value;
                temp.key = key;
                map.put(key,temp);
                addNode(temp);
            }
        }

        //Adding helper methods
        public void addNode(Node t){
            Node headNext = head.next;
            head.next = t;
            t.prev = head;
            t.next = headNext;
            headNext.prev = t;
        }

        public void removeNode(Node t){
            Node prev = t.prev;
            Node next = t.next;
            prev.next = next;
            next.prev = prev;
        }
    }
}
