public class CircularLinkedList {

    static class Node {
        int value;

        public Node(int value) {
            this.value = value;
        }

        Node next;
    }
    static Node last=null;
    static void addToEmpty(Node n){
            last=n;
            last.next=last;
    }
    static void addEnd(int value){
        Node n=new Node(value);

        if(last==null){
            addToEmpty(n);

        }
        else{
            n.next=last.next;
            last.next=n;
            last=n;

        }
        //System.out.println(last.value+"last value"+last.next.value);
    }

    static void addMiddle(int value,int k){
        Node n=new Node(value);
        Node temp=last.next;
        while(temp.value!=k){
            temp=temp.next;
        }
        n.next=temp.next;
        temp.next=n;
    }

    static void addFront(int value){
        Node n=new Node(value);

        if(last==null){
            addToEmpty(n);

        }
        else {
            n.next=last.next;
            last.next=n;
        }
    }



    static void printData(){
        Node p=last.next;
        do{
            System.out.println(p.value);
        p=p.next;
        }while(p!=last.next);
    }

    public static void main(String[] args) {
        for(int i=0;i<4;i++){
            addEnd(i);
        }
       // addMiddle(7 ,2);
      printData();

    }
}
