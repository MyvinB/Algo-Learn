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

    public ListNode mergeKListMergeSort(ListNode[] lists){
        if(lists.length==0) return null;
        return mergeKLists(lists ,0,lists.length-1);
    }

    public ListNode mergeKLists(ListNode[] lists,int start,int end){
        if(end<start){
            return null;
        }
        if(start==end) return lists[start];
        if(start+1==end) return mergeTwoList(lists[start],lists[end]);
        int mid = start + (end-start)/2;
        ListNode left = mergeKLists(lists,start,mid);
        ListNode right = mergeKLists(lists,mid+1,end);
        return mergeTwoList(left,right);
    }

    public ListNode mergeTwoList(ListNode l1,ListNode l2){
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if(l1.val<=l2.val){
            l1.next = mergeTwoList(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoList(l1,l2.next);
            return l2;
        }
    }
}

