package LeetCode.SystemDesign;/*
 @author Myvin Barboza
 31/07/20 1:15 PM 
 */

import java.util.HashMap;

public class LC460LFUCache {


}

class LFUCache {
    final int capacity;
    int minFreq;
    int curSize;
    HashMap<Integer,Node> map=new HashMap<>();
    HashMap<Integer,DoubleLinkedList> freqMap=new HashMap<>();

    class Node{
        int key;
        int val;
        int freq;
        Node next;
        Node prev;

        Node(int key,int val){
            this.key=key;
            this.val=val;
            this.freq=1;
        }
    }

    class DoubleLinkedList{
        Node head=new Node(0,0);
        Node tail=new Node(0,0);
        int listSize=0;

        DoubleLinkedList(){
            head.next=tail;
            tail.prev=head;
        }

        void add(Node node){
            Node next=head.next;
            head.next=node;
            node.next=next;
            node.prev=head;
            next.prev=node;
            listSize++;
        }

        void remove(Node node){
            Node next=node.next;
            Node prev=node.prev;
            prev.next=next;

            next.prev=prev;
            listSize--;
        }
        Node removeTail(){
            Node tailPrev=tail.prev;
            remove(tailPrev);
            return tailPrev;
        }

    }


    public LFUCache(int capacity) {
        this.capacity=capacity;
        this.minFreq=0;
        this.curSize=0;
    }

    public int get(int key) {
        Node curNode=map.get(key);
        if(curNode==null) return -1;
        else {
            updateNode(curNode);
        }
        return curNode.val;
    }

    public void put(int key, int value) {
        if(capacity==0) return;
        Node curNode=map.get(key);
        if(curNode!=null){
            curNode.val=value;
            updateNode(curNode);
        }
        else{
            curSize++;
            if(curSize>capacity){
                DoubleLinkedList list=freqMap.get(minFreq);
                Node toRemove=list.removeTail();
                map.remove(toRemove.key);
                curSize--;
            }
            minFreq=1;
            Node newNode=new Node(key,value);
            DoubleLinkedList list=freqMap.getOrDefault(1,new DoubleLinkedList());
            list.add(newNode);
            freqMap.put(1,list);
            map.put(key,newNode);
        }
    }

    public void updateNode(Node node){
        int curFreq=node.freq;
        DoubleLinkedList list=freqMap.get(curFreq);
        list.remove(node);

        if(curFreq==minFreq && list.listSize==0){
            minFreq++;
        }

        node.freq++;
        DoubleLinkedList newList=freqMap.getOrDefault(node.freq,new DoubleLinkedList());
        newList.add(node);
        freqMap.put(node.freq,newList);

    }
}

