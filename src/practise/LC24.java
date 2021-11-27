package practise;

/**
 * @author mmichaelbarboza
 * on 12:26 PM 11/27/2021
 */
public class LC24 {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0) ;
        dummy.next = head;
        ListNode cur = dummy;
        while(cur.next!=null && cur.next.next!=null){
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            first.next= second.next;
            cur.next = second;
            cur.next.next= first;
            cur = cur.next.next;
        }
        return dummy.next;
    }
}
