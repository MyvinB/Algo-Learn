package LinkedList;

/*
 @author Myvin Barboza
 28/04/20 6:32 PM 
 */public class ReverseLinkedListLC206 {


    public ListNode reverseList(ListNode head) {
        ListNode current=head;
        ListNode prev=null;
        ListNode next=null;

        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;

        }
        head=prev;
        return head;
    }

    public static void main(String[] args) {

    }
}