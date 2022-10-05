package LeetCodeChallenge.Oct2022.LinkedList;

import TopicWise2022.common.ListNode;

public class LC21 {

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


}
