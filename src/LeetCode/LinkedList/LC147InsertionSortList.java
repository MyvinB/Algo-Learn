package LeetCode.LinkedList;

public class LC147InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        ListNode prev = dummy;
        while (cur != null) {
            ListNode next = cur.next;

            if (prev.val > cur.val)
                prev = dummy;

            while (prev.next != null && prev.next.val < cur.val)
                prev = prev.next;

            cur.next = prev.next;
            prev.next = cur;
            cur = next;
        }
        return dummy.next;
    }
}
