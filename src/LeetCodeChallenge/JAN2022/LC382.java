package LeetCodeChallenge.JAN2022;

import java.util.Random;

/**
 * @author mmichaelbarboza
 * on 6:01 PM 1/7/2022
 */
public class LC382 {



  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public LC382(ListNode head) {
        this.head = head;
        rand = new Random();
    }
    public static void main(String[] args) {
    }
    ListNode head=null;
    Random rand=null;


    public int getRandom() {
        ListNode t = head;
        int res = -1;
        for(int i=1;t!=null;i++){
            if(rand.nextInt(i) == i-1){
                res=t.val;
            }
            t=t.next;
        }
        return res;
    }
}
