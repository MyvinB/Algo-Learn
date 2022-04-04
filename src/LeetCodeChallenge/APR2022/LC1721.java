package LeetCodeChallenge.APR2022;

/**
 * @author mmichaelbarboza
 * on 7:54 AM 4/4/2022
 * Time Taken: 1 hr
 * Need to understand one pass and different test cases through example
 * difficulty a bit hard
 */
public class LC1721 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(4);
        n.next.next.next.next = new ListNode(5);
        swapNodes(n,1);
    }

    public static ListNode swapNodes(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode firstPrev = dummy;
        //0 1,2,3,4,5
        for(int i=0;i<k-1;i++){
            firstPrev = firstPrev.next;
        }
        ListNode secondPrev = dummy;
        //If we iterate from first prev we would reach that positon which would give second prev
        // here we advance once such that its the next to first prev and then once again so it reaches null
        ListNode advance = firstPrev.next.next;
        while(advance!=null){
            secondPrev = secondPrev.next;
            advance = advance.next;
        }

        ListNode first = firstPrev.next;
        ListNode second = secondPrev.next;
        ListNode firstNext = first.next;
        ListNode secondNext = second.next;
        //Run the below cases to understand clashing cases
        //eg 1 2 3 4 5 6  k = 3 for first.next = second
        // eg 1 2 3 4 k = 2 for second.next = first

        if(first.next == second){
            firstPrev.next = second;
            second.next = first;
            first.next = secondNext;
        }else if(second.next == first){
            secondPrev.next = first;
            first.next = second;
            second.next = firstNext;
        }else {
            firstPrev.next = second;
            secondPrev.next = first;
            first.next = secondNext;
            second.next = firstNext;
        }

        return dummy.next;
    }
}
