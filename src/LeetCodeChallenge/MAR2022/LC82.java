package LeetCodeChallenge.MAR2022;

/**
 * @author mmichaelbarboza
 * on 12:21 PM 3/9/2022
 * Time Taken:
 */
public class LC82 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static void main(String[] args) {

    }

    public ListNode deleteDuplicatesIterative(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;

        //1->2->5
        while(cur!=null){
            while(cur.next!=null && cur.val == cur.next.val){
                cur = cur.next;
            }
            if(prev.next == cur){
                prev = prev.next;
            }
            else {
                prev.next = cur.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
    //Recursive
    public ListNode deleteDuplicates(ListNode head){
        if(head==null||head.next==null) return head;

        if(head.val!= head.next.val){
            head.next = deleteDuplicates(head.next);
            return head;
        }
        else{
            while( head.next !=null && head.val == head.next.val){
                head = head.next;
            }
        return deleteDuplicates(head.next);
        }
    }

}
