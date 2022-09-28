package LeetCodeChallenge.Sep2022.DailyChallenege;

import TopicWise2022.common.ListNode;

public class LC19 {

    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        for(int i=0;i<n;i++) fast = fast.next;
        if(fast==null) return head.next;
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
