package Company.Amazon;

/**
 * @author mmichaelbarboza
 * on 10:36 AM 3/22/2022
 * Time Taken:
 */
public class LC206 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode next = null;
        ListNode prev = null;
        while(cur!=null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
