package LeetCodeChallenge.JULY2021;

import java.util.List;

public class LC25 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy.next;
        int totalNodes = 0;
        while (cur != null) {
            cur = cur.next;
            totalNodes++;
        }
        ListNode next = null;
        ListNode prev = dummy;
        while (totalNodes >= k) {
            cur = prev.next;
            next = cur.next;
            for(int i=1;i<k ;i++){
                cur.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = cur.next;
            }
            totalNodes = totalNodes - k;
            prev = cur;
        }
        return dummy.next;
    }
}
