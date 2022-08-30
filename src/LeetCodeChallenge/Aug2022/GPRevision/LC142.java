package LeetCodeChallenge.Aug2022.GPRevision;

import TopicWise2022.common.ListNode;

public class LC142 {
    public static void main(String[] args) {

    }

    public ListNode getIntersection(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while( fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow ==fast) return slow;
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = getIntersection(head);
        if(fast==null) return null;
        ListNode slow = head;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}


