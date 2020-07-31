package LeetCode.SystemDesign;/*
 @author Myvin Barboza
 29/07/20 12:58 PM 
 */

import java.util.HashMap;
import java.util.Map;

public class LC146LRUCache {


}
class LRUCache {
    class Node{
        int key;
        int val;
        Node next;
        Node prev;
    }

    final Node head=new Node();
    final Node tail=new Node();
    int capacity;
    Map<Integer,Node> map;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>(capacity);
        head.next=tail;
        tail.prev=head;
    }

    public void add(Node node){
        Node next=head.next;
        head.next=node;
        node.prev=head;
        node.next=next;
        next.prev=node;
    }

    public void remove(Node node){
        Node prev=node.prev;
        Node next=node.next;
        prev.next=next;
        next.prev=prev;
    }

    public int get(int key) {
        int result=-1;
        Node node=map.get(key);
        if(node!=null){
            result=node.val;
            remove(node);
            add(node);

        }
        return result;
    }

    public void put(int key, int value) {
        Node node=map.get(key);
        if(node!=null){
            remove(node);
            node.val=value;
            add(node);
        }
        else {
            if(map.size()==capacity){
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node newNode=new Node();
            newNode.key=key;
            newNode.val=value;
            map.put(key,newNode);
            add(newNode);
        }
    }

}