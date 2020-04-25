import java.util.HashMap;
import java.util.Map;

/*
 @author Myvin Barboza
 24/04/20 4:30 PM 
 */public class LRUCacheLC146 {


    static class LRUCache {
        final Node head=new Node();
        final Node tail=new Node();
        Map<Integer,Node> map;
        int cache_capacity;

        public LRUCache(int capacity) {
            map=new HashMap<>(capacity);
            this.cache_capacity=capacity;
            head.next=tail;
            tail.prev=head;
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
            }else{
                if(map.size()==cache_capacity){
                    map.remove(tail.prev.key);
                    remove(tail.prev);
                }
                Node new_node=new Node();
                new_node.key=key;
                new_node.val=value;
                map.put(key,new_node);
                add(new_node);
            }
        }

        public void add(Node node){
            Node head_next=head.next;
            head.next=node;
            node.prev=head;
            node.next=head_next;
            head_next.prev=node;
        }

        public void remove(Node node){
            Node next_node=node.next;
            Node prev_node=node.prev;
            next_node.prev=prev_node;
            prev_node.next=next_node;
        }

        class Node{
            int key;
            int val;
            Node prev;
            Node next;
        }
    }





     public static void main(String[] args) {
        LRUCache l=new LRUCache(1);
        l.put(2,1);
        //l.put(2,2);
         System.out.println(l.get(2));



    }
}