package practise;

/**
 * @author mmichaelbarboza
 * on 9:39 AM 11/27/2021
 */
public class LC2 {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(5);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l2.next= new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode res = addTwoNumbers(l1,l2);

        while(res!=null){
            System.out.println(res.val);
            res= res.next;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int carry =0;
        int sum =0;
        ListNode prev = null;

        while(l1 != null || l2 !=null){
            sum /= 10;
            if(l1 != null){
                sum += l1.val;
                l1=l1.next;
            }
            if(l2 !=null){
                sum+= l2.val;
                l2 = l2.next;
            }
            dummy.next = new ListNode(sum%10);
            dummy = dummy.next;
        }

        if(sum/10==1){
            dummy.next=new ListNode(1);
        }

        return head.next;

    }
}
