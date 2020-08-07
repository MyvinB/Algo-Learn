package LeetCode.LinkedList;/*
 @author Myvin Barboza
 07/08/20 12:44 PM 
 */

import java.util.HashMap;

public class LC138CopyListwithRandomPointer {
    public static void main(String[] args) {

    }


// Definition for a Node.
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

    // O(1) SPACE
    public Node copyRandomListLessSpace(Node head) {

        if(head==null) return null;

        Node n=head;
        //making a copy in the list itself
        while(n!=null){
            Node next=n.next;
            n.next=new Node(n.val);
            n.next.next=next;
            n=next;
        }

        //assigning the random pointers
        n=head;
        while(n!=null){
            if(n.random!=null){
                n.next.random=n.random.next;

            }
            n=n.next.next;
        }

        //extracting the copy list from the main
        Node copyHead=head.next;
        Node copy=copyHead;
        n=head;
        while(copy.next!=null){
            n.next=n.next.next;
            n=n.next;

            copy.next=copy.next.next;
            copy=copy.next;


        }
        //set the last pointer to null as it is still pointing to its copy
        n.next=null;

        return copyHead;

    }


    public Node copyRandomList(Node head) {
        //O(n) space

        if(head==null) return null;
        HashMap<Node,Node> map=new HashMap<>();

        Node n=head;
        while(n!=null){
            map.put(n,new Node(n.val));
            n=n.next;
        }

        n=head;
        while(n!=null){
            map.get(n).next=map.get(n.next);
            map.get(n).random=map.get(n.random);
            n=n.next;
        }
        return map.get(head);
    }
}
