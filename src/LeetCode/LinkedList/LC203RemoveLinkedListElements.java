package LeetCode.LinkedList;/*
 @author Myvin Barboza
 20/07/20 3:32 PM 
 */

public class LC203RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode cur=head;
        ListNode pre=dummy;
        while(cur!=null){
            if(cur.val==val){
                cur=cur.next;
                pre.next=cur;
            }else {
                pre=cur;
                cur=cur.next;
            }
        }

        return dummy.next;
    }

}
