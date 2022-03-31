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
                size++;
            }

            public void removeNode(Node node){
                Node next = node.next;
                Node prev = node.prev;
                prev.next = next;
                next.prev = prev;
                size--;
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
            Node node = map.get(key);
            if(node==null) return -1;
            updateNode(node);
            return node.val;
        }

        public void put(int key, int value) {
            if(capacity==0) return;
            Node node = null;
            if(map.containsKey(key)){
                node = map.get(key);
                node.val = value;
                updateNode(node);
            }else{
                node = new Node();
                node.key = key;
                node.val = value;
                if(map.size() == capacity){
                    DList oldList = freqMap.get(leastfreqCount);
                    Node temp = oldList.removeLast();
                    map.remove(temp.key);
                }
                leastfreqCount = 1;
                DList newList = freqMap.getOrDefault(node.freq,new DList());
                newList.addNode(node);
                map.put(key,node);
                freqMap.put(leastfreqCount,newList);
            }
        }

        //Helper updated the value when already exisiting key or getting the calue
        public void updateNode(Node node){
            DList oldList = freqMap.get(node.freq);
            oldList.removeNode(node);
            if(leastfreqCount==node.freq && oldList.size==0){
                leastfreqCount++;
            }
            node.freq++;
            DList newList = freqMap.getOrDefault(node.freq,new DList());
            newList.addNode(node);
            freqMap.put(node.freq,newList);
        }
    }
}
