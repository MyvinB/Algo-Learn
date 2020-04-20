package LinkedList;

/*
 @author Myvin Barboza
 20/04/20 10:43 AM 
 */public class PartitionListLC86 {

    static ListNode partition(ListNode head, int x) {
        ListNode dummy1=new ListNode(0); ListNode dummy2=new ListNode(0);
        ListNode curr1=dummy1 ;ListNode curr2=dummy2;
        while(head!=null){
            if(head.val<x){
                curr1.next=head;
                curr1=head;
            }
            else {
                curr2.next=head;
                curr2=head;
            }
            head=head.next;
        }
        curr2.next=null;
        curr1.next=dummy2.next;
        return dummy1.next;

    }


     public static void main(String[] args) {

    }
}