package LeetCodeChallenge.July2022;

import TopicWise2022.common.ListNode;

public class LC86 {

    public static void main(String[] args) {

    }

    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode cur1 = dummy1;
        ListNode cur2 = dummy2;
        ListNode temp = head;
        while(temp!=null){
            if(temp.val<x){
                cur1.next = temp;
                cur1 = temp;
            }
            else{
                cur2.next = temp;
                cur2 = temp;
            }
            temp = temp.next;
        }
        cur2.next = null;
        cur1.next = dummy2.next;
        return dummy1.next;
    }
}
