package LeetCodeChallenge.July2022;

import TopicWise2022.common.ListNode;

public class LC25 {

    public static void main(String[] args) {

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        //Calc total
        int total = 0;
        ListNode dummy = new ListNode(-1);
        ListNode temp = head;
        while(temp!=null){
            total++;
            temp=temp.next;
        }
        ListNode prev = dummy;
        ListNode next = null;
        ListNode cur = head;
        dummy.next = head;
        while(total>=k){
            cur= prev.next;
            next = cur.next;
            for(int i=1;i<k;i++){
                cur.next= next.next;
                next.next = prev.next;
                prev.next = next;
                next = cur.next;
            }
            prev = cur;
            total = total-k;
        }
        return dummy.next;
    }
}
