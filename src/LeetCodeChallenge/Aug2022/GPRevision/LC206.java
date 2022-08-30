package LeetCodeChallenge.Aug2022.GPRevision;

import TopicWise2022.common.ListNode;

public class LC206 {


    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;
        while(cur!=null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
