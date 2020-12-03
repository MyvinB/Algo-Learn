package LeetCode.LinkedList;/*
 @author Myvin Barboza
 03/12/20 11:22 AM 
 */

import java.util.Random;



public class LC382 {
    ListNode head = null;
    Random rand = null;

    public LC382(ListNode head) {
        this.head = head;
        this.rand = new Random();
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        int res = -1;
        ListNode t = this.head;
        for (int i = 1; t != null; i++) {
            if (rand.nextInt(i) == i - 1)
                res = t.val;
            t = t.next;
        }
        return res;
    }
}
