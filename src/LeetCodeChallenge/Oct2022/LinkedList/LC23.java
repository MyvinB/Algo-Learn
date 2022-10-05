package LeetCodeChallenge.Oct2022.LinkedList;

import TopicWise2022.common.ListNode;

import java.util.PriorityQueue;

public class LC23 {

    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKlists(lists,0,lists.length-1);
    }

    public ListNode mergeKlists(ListNode[] lists,int start,int end){
        if(end<start) return null;
        if(start==end) return lists[start];
        if(start+1==end) return mergeTwoLists(lists[start],lists[end]);
        else{
            int mid = start +(end-start)/2;
            ListNode leftHalf = mergeKlists(lists,start,mid);
            ListNode rightHalf = mergeKlists(lists,mid+1,end);
            return mergeTwoLists(leftHalf,rightHalf);
        }
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(l1!=null || l2!=null){
            if(l1==null){
                cur.next =  l2;
                break;
            }
            if(l2==null){
                cur.next =  l1;
                break;
            }
            if(l1.val<=l2.val){
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    //Much easier pq soln
    public ListNode mergeKListsPQ(ListNode[] lists) {
        if(lists.length==0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null)
                pq.offer(lists[i]);
        }
        ListNode dummy = new ListNode(-1);
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
}
