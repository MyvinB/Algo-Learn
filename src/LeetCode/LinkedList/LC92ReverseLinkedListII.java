package LeetCode.LinkedList;
/*
 @author Myvin Barboza
 19/05/20 11:19 AM 
 */

public class LC92ReverseLinkedListII {

    static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy;
        //dummy->1>
        for (int i = 0; i <m-1 ; i++) {
            pre=pre.next;
        }
        System.out.println(pre.val);
        ListNode start=pre.next;
        ListNode current=start;
        ListNode next=null;
        ListNode prev=null;
        int i=m;
        while(i<n){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
            i++;
        }
        ListNode end=current.next;
        current.next=prev;
        pre.next=current;
        start.next=end;

       return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n=new ListNode(0);
        n.next=new ListNode(3);
        n.next.next=new ListNode(5);
//        n.next.next.next=new ListNode(3);
//        n.next.next.next.next=new ListNode(4);
//        n.next.next.next.next.next=new ListNode(5);
        n=reverseBetween(n.next,1,2);
        while(n!=null){
            System.out.print(n.val+"->");
            n=n.next;
        }


    }   
}