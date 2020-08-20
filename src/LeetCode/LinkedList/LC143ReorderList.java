package LeetCode.LinkedList;/*
 @author Myvin Barboza
 20/08/20 5:07 PM 
 */

public class LC143ReorderList {
    public static void main(String[] args) {

    }

    public void reorderList(ListNode head) {
        if(head==null) return;
        ListNode p1=head;
        ListNode p2=head;
        while(p2.next!=null && p2.next.next!=null){
            p1=p1.next;
            p2=p2.next.next;
        }
        ListNode middle=p1;
        ListNode current=p1.next;
        ListNode prev=null;
        ListNode next=null;
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        p1.next=prev;
        p1=head;
        p2=middle.next;
        while(p1!=middle){
            middle.next=p2.next;
            p2.next=p1.next;
            p1.next=p2;
            p1=p2.next;
            p2=middle.next;
        }
    }

}
