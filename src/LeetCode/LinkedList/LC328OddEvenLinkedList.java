package LeetCode.LinkedList;
/*
 @author Myvin Barboza
 16/05/20 6:09 PM 
 */

public class LC328OddEvenLinkedList {


    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode odd=head;
        ListNode even=head.next;
        ListNode eventemp=even;
        ListNode temp=head;

        while(odd.next!=null && even.next!=null){
            odd.next=odd.next.next;
            even.next=even.next.next;
            odd=odd.next;
            even=even.next;
        }
        odd.next=eventemp;
        return head;
    }


    public static void main(String[] args) {

    }
}