package LeetCodeChallenge.Aug2022.GPRevision;

import TopicWise2022.common.ListNode;

public class LC25 {

    public static void main(String[] args) {

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int totalCount = 0;
        ListNode temp = head;
        while(temp!=null){
            totalCount++;
            temp = temp.next;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        ListNode next = null;
        ListNode prev = dummy;
        while(totalCount>=k){
            cur = prev.next;
            next = cur.next;
            for(int i=1;i<k;i++){
                cur.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = cur.next;
            }
            totalCount -= k;
            prev = cur;
        }
        return dummy.next;
    }
}
