package LeetCodeChallenge.Oct2022.LinkedList;

import TopicWise2022.common.ListNode;

public class LC25 {


    public static void main(String[] args) {

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int totalCount = 0;
        ListNode temp = head;
        while(temp!=null){
            temp= temp.next;
            totalCount++;
        }
        ListNode prev = dummy;
        ListNode cur = null;
        ListNode next = null;
        while(totalCount>=k){
            cur = prev.next;
            next = cur.next;
            for(int i=1;i<k;i++){
                cur.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = cur.next;
            }
            prev = cur;
            totalCount = totalCount-k;
        }
        return dummy.next;
    }
}
