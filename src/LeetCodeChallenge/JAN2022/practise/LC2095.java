package LeetCodeChallenge.JAN2022.practise;

/**
 * @author mmichaelbarboza
 * on 8:21 PM 1/8/2022
 */
public class LC2095 {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
         ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public static void main(String[] args) {

    }

    public ListNode deleteMiddle(ListNode head) {
        if(head.next==null) return null;
        ListNode t = head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next = prev.next.next;
        return head;

    }
}
