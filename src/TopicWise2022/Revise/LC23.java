package TopicWise2022.Revise;

import TopicWise2022.common.ListNode;

import java.util.PriorityQueue;

public class LC23 {



    public static void main(String[] args) {

    }

    public ListNode mergeKListsPQ(ListNode[] lists) {
        if(lists.length==0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode i:lists){
            if(i!=null)
                pq.offer(i);
        }
        ListNode dummy = new ListNode(-1) ;
        ListNode cur = dummy;
        while(!pq.isEmpty()){
            ListNode temp = pq.poll();
            cur.next = temp;
            cur = cur.next;
            if(temp.next!=null){
                pq.offer(temp.next);
            }
        }
        return dummy.next;

    }

    public ListNode mergeKListsNOQ(ListNode[] lists){
        return mergeKLists(lists,0,lists.length-1);
    }

    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(true){
            if(l1==null){
                cur.next = l2;
                break;
            }
            if(l2==null){
                cur.next = l1;
                break;
            }
            if(l1.val<=l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }


    public ListNode mergeKLists(ListNode[] lists,int start, int end){
        if(start==end) return lists[start];
        if(start+1==end) return mergeTwoLists(lists[start],lists[end]);
        else{
            int mid = start + (end-start)/2;
            ListNode firstHalf = mergeKLists(lists,start,mid);
            ListNode secondHalf = mergeKLists(lists,mid+1,end);
            return mergeTwoLists(firstHalf,secondHalf);

        }
    }
}
