package practise;

import java.util.HashMap;

public class LC460LFU {


    static class LFUCache {
        static class Node{
            int key,val,freq;
            Node prev,next;
            Node(int key, int val){
                this.key = key;
                this.val = val;
                this.freq = 1;
            }
        }
        static class DList{
            Node head,tail;
            int size;
            DList(){
                head = new Node(0, 0);
                tail = new Node(0, 0);
                head.next = tail;
                tail.prev = head;
            }
            void addNode(Node node){
                Node head_next = head.next;
                head.next = node;
                node.prev = head;
                node.next= head_next;
                head_next.prev = node;
                size++;
            }

            void removeNode(Node node){
                Node next = node.next;
                Node prev = node.prev;
                prev.next = next;
                next.prev = prev;
                size--;
            }

            Node removeLast(){
                if(size>0){
                    Node node = tail.prev;
                    removeNode(node);
                    return node;
                }
                return null;
            }
        }
        HashMap<Integer,DList> freqMap;
        int leastFreqCount;
        HashMap<Integer,Node> map;
        int capacity;
        int totalSize;
        public LFUCache(int capacity) {
            freqMap= new HashMap<>();
            map = new HashMap<>();
            this.capacity = capacity;
        }

        public static void main(String[] args) {
            LFUCache test = new LFUCache(2);
            test.put(1,1);
            test.put(2,2);
            System.out.println("fre"+test.leastFreqCount);
            System.out.println(test.get(1));
            System.out.println("fre"+test.leastFreqCount);

            test.put(3,3);
            System.out.println("fre"+test.leastFreqCount);

            System.out.println(test.get(2));
            System.out.println("fre"+test.leastFreqCount);

            System.out.println(test.get(3));
            System.out.println("Lastfre"+test.leastFreqCount);

            test.put(4,4);
            System.out.println("fre"+test.leastFreqCount);

            System.out.println(test.get(1));
            System.out.println(test.get(3));
            System.out.println(test.get(4));

        }
        public int get(int key) {
            Node node = map.get(key);
            if(node== null) return -1;
            update(node);
            return node.val;
        }

        public void put(int key, int value) {
            Node node;
            if(map.containsKey(key)){
                node = map.get(key);
                node.val = value;
                update(node);
            }
            else{
                 node = new Node(key, value);
                 if( totalSize == capacity){
                     DList oldList = freqMap.get(leastFreqCount);
                     map.remove(oldList.removeLast().key);
                     totalSize--;
                 }
                 totalSize++;
                 map.put(key,node);
                 //becomes one again cause there is new element that is least recenetly used remember update increments the count
                 leastFreqCount=1;
                 DList newList = freqMap.getOrDefault(node.freq, new DList());
                 newList.addNode(node);
                 freqMap.put(node.freq,newList);
            }
        }

        void update(Node node){
            DList oldList = freqMap.get(node.freq);
            oldList.removeNode(node);
            if(leastFreqCount == node.freq && oldList.size == 0){
                leastFreqCount++;
            }
            node.freq++;
            DList newList = freqMap.getOrDefault(node.freq, new DList());
            newList.addNode(node);
            freqMap.put(node.freq,newList);
        }
    }
}
