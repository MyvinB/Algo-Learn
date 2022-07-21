package LeetCodeChallenge.July2022;

import TopicWise2022.common.ListNode;

public class LC92 {

    public static void main(String[] args) {

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        int k = right-left+1;
        ListNode cur = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = cur;
        ListNode next = null;
        ListNode pre = dummy;
        for(int i=1;i<left;i++){
            pre = cur;
            cur = cur.next;
        }
        next = cur.next;
        for(int i=1;i<k;i++){
            cur.next = next.next;
            next.next=pre.next;
            pre.next = next;
            next = cur.next;
        }
        return dummy.next;
    }
}
