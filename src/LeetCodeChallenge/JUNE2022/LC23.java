package LeetCodeChallenge.JUNE2022;

import TopicWise2022.common.ListNode;

public class LC23 {


    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKList(lists,0,lists.length-1);
    }

    public ListNode mergeTwoList(ListNode l1,ListNode l2){
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


    public ListNode mergeKList(ListNode[] lists, int start,int end){
        if(end<start) return null;
        else if(start==end) return lists[start];
        else if(start+1==end) return mergeTwoList(lists[start],lists[end]);
        else {
            int mid = start + (end-start)/2;
            ListNode first = mergeKList(lists,start,mid);
            ListNode second = mergeKList(lists,mid+1,end);
            return mergeTwoList(first,second);
        }
    }
}
