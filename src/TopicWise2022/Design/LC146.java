package TopicWise2022.Design;

import java.util.HashMap;

/**
 * @author mmichaelbarboza
 * on 10:56 AM 3/31/2022
 * Time Taken:
 */
public class LC146 {

    public static void main(String[] args) {

    }

    class LRUCache {

        Node head = new Node();
        Node tail = new Node();
        int capacity;
        HashMap<Integer,Node> map;

        class Node{
            int key;
            int val;
            Node prev;
            Node next;
        }

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            Node temp = map.get(key);
            if(temp == null) return -1;
            removeNode(temp);
            addNode(temp);
            return temp.val;
        }

        public void put(int key, int value) {
            if(map.containsKey(key)){
                Node temp = map.get(key);
                temp.val = value;
                map.put(key,temp);
                removeNode(temp);
                addNode(temp);
            }else{
                if(map.size()==capacity){
                    map.remove(tail.prev.key);
                    removeNode(tail.prev);
                }
                Node temp = new Node();
                temp.val = value;
                temp.key = key;
                addNode(temp);
                map.put(key,temp);
            }
        }

        // Helper methods
        // add in the front
        public void addNode(Node a){
            Node head_next = head.next;
            head.next = a;
            a.prev = head;
            a.next = head_next;
            head_next.prev = a;
        }
        //Remove node from anywhere
        public void removeNode(Node a){
            Node next = a.next;
            Node prev = a.prev;
            prev.next = next;
            next.prev = prev;
        }
    }
}
