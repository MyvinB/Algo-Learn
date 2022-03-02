package practise;

public class LoopDetection {
    static class Node {
        int value;

        public Node(int value) {
            this.value = value;
        }

        Node next;
    }

    static Node head;
    static boolean loopDetect(){
        Node slow=head;
        Node fast=head;

        while(slow!=null&&fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Node one=new Node(1);
        Node two =new Node(2);
        Node three=new Node(3);
        Node four=new Node(4);
        head=one;
        head.next=two;
        two.next=three;
        three.next=four;

        System.out.println(loopDetect());



    }
}
