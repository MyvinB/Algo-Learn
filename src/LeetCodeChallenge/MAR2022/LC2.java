package LeetCodeChallenge.MAR2022;

/**
 * @author mmichaelbarboza
 * on 9:10 AM 3/11/2022
 * Time Taken:
 */
public class LC2 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        int sum  = 0;
        while(true){
            sum = sum/10;
            if(l1!=null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                sum += l2.val;
                l2 = l2.next;
            }
            temp.next = new ListNode(sum%10);
            temp = temp.next;
            if(l1 == null && l2 == null){
                break;
            }
        }
        if(sum/10==1) temp.next = new ListNode(1);
        return dummy.next;
    }
}
