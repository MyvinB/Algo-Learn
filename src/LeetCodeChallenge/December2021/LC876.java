package LeetCodeChallenge.December2021;

import LeetCodeChallenge.Requirements;

/**
 * @author mmichaelbarboza
 * on 12:30 PM 12/28/2021
 */
public class LC876 {
    public class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }
    public static void main(String[] args) {

    }

    public ListNode middleNode(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
