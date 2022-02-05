package LeetCodeChallenge.Feb2022;

import java.util.PriorityQueue;

/**
 * @author mmichaelbarboza
 * on 9:40 AM 2/5/2022
 * Time Taken:
 */
public class LC23 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
        for(ListNode n:lists){
            if(n!=null)
            pq.offer(n);
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(pq.size()!=0){
            ListNode minElement = pq.poll();
            cur.next = minElement;
            cur=cur.next;
            if(minElement.next!=null){
                pq.offer(minElement.next);
            }
        }
        return dummy.next;
    }
}

