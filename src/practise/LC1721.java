package practise;

/**
 * @author mmichaelbarboza
 * on 1:47 PM 11/27/2021
 */
public class LC1721 {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next= new ListNode(3);
        n.next.next.next = new ListNode(4);
        n.next.next.next.next = new ListNode(5);
        n.next.next.next.next.next = new ListNode(6);
        ListNode res = swapNodes(n,2);
        while(res!=null){
            System.out.print(res.val+"->");
            res=res.next;
        }


    }

    public static ListNode swapNodes(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode firstPrev=dummy;
        for(int i=0;i<k-1;i++){
            firstPrev = firstPrev.next;
        }
        ListNode secondPrev= dummy;
        ListNode advance = firstPrev.next.next;

        while(advance!=null){
            secondPrev = secondPrev.next;
            advance = advance.next;
        }

        ListNode first = firstPrev.next;
        ListNode second = secondPrev.next;
        ListNode firstNext = first.next;
        ListNode secondNext = second.next;

        second.next = firstNext;
        first.next = secondNext;
        firstPrev.next = second;
        secondPrev.next = first;

        return dummy.next;

    }
}
