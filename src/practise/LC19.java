package practise;

/**
 * @author mmichaelbarboza
 * on 10:27 AM 11/27/2021
 */
public class LC19 {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        ListNode res = removeNthFromEnd(l1,3);

        while(res!=null){
            System.out.println(res.val);
            res= res.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode slow = head;
       ListNode fast = head;
       for(int i=0;i<n;i++){
           fast=fast.next;
       }
       if(fast==null){
           return head.next;
       }
       while(fast.next!=null){
           slow=slow.next;
           fast=fast.next;
       }

       slow.next = slow.next.next;
       return head;

    }
}
