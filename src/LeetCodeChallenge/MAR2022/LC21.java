package LeetCodeChallenge.MAR2022;

/**
 * @author mmichaelbarboza
 * on 8:42 AM 3/7/2022
 * Time Taken:
 */
public class LC21 {


     public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public static void main(String[] args) {

    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while(true){
            if(l1 == null){
                dummy.next = l2;
                break;
            }
            if(l2 == null){
                dummy.next = l1;
                break;
            }
            if(l1.val<=l2.val){
                dummy.next = l1;
                l1 = l1.next;
            }
            else if(l2.val<l1.val){
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        return head.next;
    }


}
