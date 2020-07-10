package LeetCode.Stack;/*
 @author Myvin Barboza
 10/07/20 5:04 PM 
 */

import java.util.Stack;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};

public class LC430FlattenAMultilevelDoublyLinkedList {

    public static void main(String[] args) {

    }

    public Node flatten(Node head) {
        Node current=head;
        Stack<Node> stack=new Stack();
        while(current!=null || !stack.isEmpty()){
            if(current.child!=null){
                if(current.next!=null)
                    stack.push(current.next);
                current.next=current.child;
                current.next.prev=current;
                current.child=null;
            }
            else{
                if(current.next==null && !stack.isEmpty()){
                    current.next=stack.pop();
                    current.next.prev=current;
                }
            }
            current=current.next;

        }
        return head;
    }

    public Node flattenNOSTACK(Node head) {
        Node current=head;

        while(current!=null){
            if(current.child==null){
                current=current.next;
                continue;
            }

            Node temp=current.child;
            while(temp.next!=null) temp=temp.next;
            temp.next=current.next;
            if(current.next!=null) current.next.prev=temp;

            current.next=current.child;
            current.next.prev=current;
            current.child=null;

        }
        return head;

    }





}
