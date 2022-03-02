package practise;

public class DoubleLinkedList {
    static class Node{
        int value;
        Node next=null;
        Node prev=null;

        public Node(int value) {
            this.value = value;
        }
    }
   static  Node front=null;
   static  Node end=null;
   static Node temp=null;

    static void addEnd(int value){
        Node n=new Node(value);
        if(front==null){
            front=n;
            temp=front;
        }
        else{
            temp.next=n;
            n.prev=temp;
            temp=temp.next;
        }
    }

    /*Reverse*/
    static void reverse(int value){
        
    }

    public static void main(String args[]){
    for(int i=0;i<4;i++){
        addEnd(i);
    }


    temp=front;
    while(temp!=null){
        System.out.println(temp.prev+"|"+temp.value+"|"+temp.next+"("+temp+")");
        System.out.println();
        temp=temp.next;
    }

    }
}
