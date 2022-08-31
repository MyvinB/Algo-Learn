package LeetCodeChallenge.Aug2022.GPRevision;

import java.util.HashMap;

public class LC460 {

    public static void main(String[] args) {

    }

    class LFUCache {

        class Node{
            int key;
            int value;
            int freq = 1;
            Node next;
            Node prev;
        }

        class Dlist{
            Node head;
            Node tail;
            int size = 0;

            Dlist(){
                head = new Node();
                tail = new Node();
                head.next = tail;
                tail.prev = head;

            }

            public void addNode(Node t){
                Node headNext = head.next;
                head.next = t;
                t.prev = head;
                t.next = headNext;
                headNext.prev = t;
                size++;
            }

            public void removeNode(Node t){
                Node prev = t.prev;
                Node next = t.next;
                prev.next = next;
                next.prev = prev;
                size--;
            }

            public Node removeLastNode(){
                if(size!=0){
                    Node node = tail.prev;
                    removeNode(node);
                    return node;
                }
                return null;
            }
        }
        HashMap<Integer,Node> map;
        HashMap<Integer,Dlist> freqMap;
        int capacity;
        int leastFreqCount;
        public LFUCache(int capacity) {
            map = new HashMap<>();
            freqMap = new HashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if(!map.containsKey(key)) return -1;
            Node node = map.get(key);
            updateNode(node);
            return node.value;
        }

        public void put(int key, int value) {
            if(capacity==0) return;
            if(map.containsKey(key)){
                Node node = map.get(key);
                node.value = value;
                updateNode(node);
            }else{
                if(map.size()==capacity){
                    Dlist oldList = freqMap.get(leastFreqCount);
                    Node temp  = oldList.removeLastNode();
                    map.remove(temp.key);
                }
                Node node = new Node();
                node.value = value;
                node.key = key;
                leastFreqCount = 1;
                Dlist newList = freqMap.getOrDefault(node.freq,new Dlist());
                newList.addNode(node);
                map.put(key,node);
                freqMap.put(node.freq,newList);
            }
        }

        //Helper method to put it in the right freq map
        public void updateNode(Node node){
            Dlist oldList = freqMap.get(node.freq);
            oldList.removeNode(node);
            //Basically seeing that the least freq is now the new Dlist size
            if(leastFreqCount==node.freq && oldList.size==0) leastFreqCount++;
            node.freq++;
            Dlist newList = freqMap.getOrDefault(node.freq,new Dlist());
            newList.addNode(node);
            freqMap.put(node.freq,newList);
        }
    }
}
