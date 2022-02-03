package Company.ZopSmart;

import java.sql.SQLOutput;

/**
 * @author mmichaelbarboza
 * on 10:58 AM 2/3/2022
 * Time Taken:
 */
public class LC25 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

    public static void main(String[] args) {

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = head;
        int total =0;
        while(temp!=null){
            temp = temp.next;
            total++;
        }
        System.out.println("Total count is "+total);
        ListNode cur = dummy.next;
        ListNode prev = dummy;
        ListNode next =  null;
        while(total>=k){
            cur = prev.next;
            next = cur.next;
            for(int i=1;i<k;i++){
                cur.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = cur.next;
            }
            prev = cur;
            total = total-k;

        }
        return dummy.next;

    }
}
