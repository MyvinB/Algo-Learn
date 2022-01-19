package LeetCodeChallenge.JAN2022;

/**
 * @author mmichaelbarboza
 * on 11:19 AM 1/19/2022
 */
public class LC142 {
    static class ListNode {
      int val;
        ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
   }

    public static void main(String[] args) {
        ListNode a = new ListNode(3);
        a.next = new ListNode(2);
        a.next.next = new ListNode(0);
        a.next.next.next = new ListNode(-4);
        a.next.next.next.next = a.next;
        detectCycle(a);
    }

    static ListNode getIntersection(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) {
                return slow;
            }
        }
        return null;
    }

    public static ListNode detectCycle(ListNode head) {
        if(head==null ||head.next==null) return null;
        ListNode intersect = getIntersection(head);
        if(intersect == null) return null;
        ListNode start = head;
        while(intersect!=start){
            start = start.next;
            intersect = intersect.next;
        }
        return start;
    }
}
