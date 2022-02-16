package LeetCodeChallenge.Feb2022;

/**
 * @author mmichaelbarboza
 * on 10:56 PM 2/16/2022
 * Time Taken:
 */
public class LC24 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode cur = dummy;
        while(cur.next!=null && cur.next.next!=null ){
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            first.next= second.next;
            cur.next = second;
            cur.next.next = first;
            cur = cur.next.next;
        }
        return dummy.next;
    }
}
