package LinkedList;

import java.util.LinkedList;

/*
 @author Myvin Barboza
 25/04/20 10:19 AM 
 */public class KthNodeSwapGFG {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

        static Node swapkthnode(Node head, int num, int K) {
            Node s = new Node(0);
            Node e = new Node(0);
            s.next=head;
            e.next=head;
            int i = 1;
            int j = num-K;
            Node temp;
            while (i <= j) {
                if (i <= K ) {
                    s = s.next;
                }
                i++;
                e = e.next;
            }
            e=e.next;
            System.out.println(e.data+" " + s.data);
            int val = s.data;
            s.data = e.data;
            e.data = val;
            return head;

        }



     public static void main(String[] args) {
        Node n=new Node(1);
        n.next=new Node(2);
        n.next.next=new Node(3);
        n.next.next.next=new Node(4);
      //   n.next.next.next.next=new Node(5);
//        n.next.next.next.next=new Node(5);
        n=swapkthnode(n,4,1);
        while (n!=null){
            System.out.println(n.data);
            n=n.next;
        }

    }
}