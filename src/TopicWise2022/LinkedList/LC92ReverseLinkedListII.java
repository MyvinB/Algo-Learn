package TopicWise2022.LinkedList;

import TopicWise2022.common.ListNode;

public class LC92ReverseLinkedListII {

    public static void main(String[] args) {

    }
    //Similar way to reverse k nodes in a group
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null||left==right) return head;
        ListNode dummy = new ListNode(-1);
        int k = right-left+1;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode next = null;
        dummy.next = head;
        for(int i=1;i<left;i++){
            pre = cur;
            cur = cur.next;
        }
        next = cur.next;
        for(int i=1;i<k;i++){
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
            next = cur.next;
        }
        return dummy.next;
    }
}
