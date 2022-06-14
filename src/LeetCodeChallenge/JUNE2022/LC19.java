package LeetCodeChallenge.JUNE2022;

import TopicWise2022.common.ListNode;

public class LC19 {

    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

}
