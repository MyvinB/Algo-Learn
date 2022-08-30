package LeetCodeChallenge.Aug2022.GPRevision;

import TopicWise2022.common.ListNode;

public class LC141 {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while( fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow ==fast) return true;
        }
        return false;
    }
}
