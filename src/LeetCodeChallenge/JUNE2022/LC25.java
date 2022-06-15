package LeetCodeChallenge.JUNE2022;

import TopicWise2022.common.ListNode;

public class LC25 {

    public static void main(String[] args) {

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        int total = 0;
        while(temp!=null){
            total++;
            temp = temp.next;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        ListNode next = cur.next;
        while(total>=k){
            cur = prev.next;
            next = cur.next;
            for(int i=1;i<k;i++){
                cur.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = cur.next;
            }
            total = total-k;
            prev = cur;
        }
        return dummy.next;
    }


    }

