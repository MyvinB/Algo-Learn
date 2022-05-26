package TopicWise2022.LinkedList;


import TopicWise2022.common.ListNode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author mmichaelbarboza
 * on 8:53 AM 3/7/2022
 * Time Taken:
 */
public class LC23MergeKsortedList {



    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists,0, lists.length-1);
    }

    public ListNode mergeKLists(ListNode[] lists,int start,int end) {
        if(end<start) return null;
        if(start == end) return lists[start];
        if(start +1 == end) return mergeTwoList(lists[start],lists[end]);
        else{
            int mid = start + ((end-start)/2);
            ListNode firstHalf = mergeKLists(lists,start,mid);
            ListNode secondHalf = mergeKLists(lists,mid+1,end);
            return mergeTwoList(firstHalf,secondHalf);
        }
    }

    public ListNode mergeTwoList(ListNode l1, ListNode l2){
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

    public ListNode mergeKListsPQ(ListNode[] lists) {
      if(lists.length == 0) return null;
      PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode list:lists){
          if(list !=null){
              pq.offer(list);
          }
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(!pq.isEmpty()){
            ListNode temp = pq.poll();
            cur.next =temp;
            cur = cur.next;
            if(cur.next !=null){
                pq.offer(cur.next);
            }
        }
        return dummy.next;
    }
}
