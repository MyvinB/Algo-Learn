package LeetCodeChallenge.MAR2022;

import java.util.HashMap;

/**
 * @author mmichaelbarboza
 * on 5:39 PM 3/12/2022
 * Time Taken:
 */
public class LC138 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {

    }

    public Node copyRandomList(Node head) {
        //Simple hashmap 0(n) space
        HashMap<Node,Node> map = new HashMap<>();
        if(head==null) return head;
        Node n = head;
        while(n!=null){
            map.put(n,new Node(n.val));
            n = n.next;
        }
        n = head;
        while(n!=null){
            map.get(n).next = map.get(n.next);
            map.get(n).random = map.get(n.random);
            n = n.next;
        }
        return map.get(head);
    }

    //0(1) Space
    public Node copyRandomListSpaceOptimised(Node head){
        if(head == null) return head;
        Node n = head;
        //simply add the copy to the next pointer
        while(n!=null){
            Node next = n.next;
            n.next = new Node(n.val);
            n.next.next =  next;
            n = next;
        }
        n= head;
        //Assining random pointers next is taken care of
        while(n!=null){
            if(n.random !=null){
                n.next.random = n.random.next;
            }
            n = n.next.next;
        }
        //Copy nmext needs to be checked as if the next is null means no further element
        // also next pointer needs to be null as it should not have the copy at the end
        Node copyHead = head.next;
        Node copy = copyHead;
        n = head;
        //c
        while(copy.next !=null){
            n.next = n.next.next;
            n = n.next;
            copy.next = copy.next.next;
            copy = copy.next;
        }
        n.next = null;
        return copyHead;

    }
}
