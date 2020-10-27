package LeetCode.LinkedList;

/*
Important Math concept to know exlpained very well by
https://www.youtube.com/watch?v=LUm2ABqAs1w&t=1139s
 */


public class LC142LinkedListCycleII {

    public static void main(String[] args) {

    }

    static ListNode getIntersection(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }

        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode intersect = getIntersection(head);
        if (intersect == null)
            return null;
        ListNode start = head;
        while (intersect != start) {
            start = start.next;
            intersect = intersect.next;
        }
        return start;
    }
}

