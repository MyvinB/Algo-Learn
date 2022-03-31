package TopicWise2022.Design;

import java.util.HashMap;

/**
 * @author mmichaelbarboza
 * on 12:47 PM 3/31/2022
 * Time Taken:
 */
public class LC460 {

    class LFUCache {
        class Node{
            int key;
            int val;
            int freq = 1;
            Node next;
            Node prev;
        }

        class DList{
            Node head;
            Node tail;
            //size variable there when we want to remove last node cause if there is nothing we return null
            int size;
            DList(){
                head = new Node();
                tail = new Node();
                size = 0;
                head.next = tail;
                tail.prev = head;
            }

            public void addNode(Node node){
                Node head_next = head.next;
                head.next = node;
                node.prev = head;
                node.next = head_next;
                head_next.prev= node;
            }

            public void removeNode(Node node){
                Node next = node.next;
                Node prev = node.prev;
                prev.next = next;
                next.prev = prev;
            }

            Node removeLast(){
                if(size!= 0){
                    Node node = tail.prev;
                    removeNode(node);
                    return node;
                }
                return null;
            }
        }
        HashMap<Integer,DList> freqMap;
        HashMap<Integer,Node> map;
        int capacity;
        int leastfreqCount;
        public LFUCache(int capacity) {
            freqMap = new HashMap<>();
            map = new HashMap<>();
            this.capacity = capacity;

        }

        public int get(int key) {

        }

        public void put(int key, int value) {

        }
    }
}
