package practise;/*Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.*/

public class removeNthNode {
    public static class  Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next=null;
        }
    }

    static Node head;
    static Node temp;
    /*Insertion into a node*/
    static void insertValueFront(int value){
    if(head==null){
        temp=new Node(value);
        head=temp;
    }
    else{
        Node n=new Node(value);
        temp.next=n;
        temp=n;


    }
    }

   static Node removeNthFromEnd( Node head,int n) {

           Node dummy=new Node(0);
           dummy.next=head;
           Node temp=head;
           int length=0;
           while(temp!=null){
               length++;
               temp=temp.next;
           }
           //System.out.print(length);
           length=length-n;
           temp=dummy;

           //System.out.print(length);
           while(length>0){
               length--;
               temp=temp.next;
           }

           temp.next=temp.next.next;
           return dummy.next;
       }



    public static void main(String args[]){
    for(int i=1;i<=5;i++){
        insertValueFront(i);
    }

    head=removeNthFromEnd(head,2);
    while(head!=null){
        System.out.println(head.value);
        head=head.next;
    }

    }
}
