package TopicWise2022.LinkedList;

import TopicWise2022.common.ListNode;

public class LC25ReverseNodesInKGropups {

    public static void main(String[] args) {

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = head;
        int total = 0;
        while(temp!=null){
            temp = temp.next;
            total++;
        }
        System.out.println("Total size of linkedList"+ total);
        ListNode cur = head;
        ListNode prev = dummy;
        ListNode next = cur.next;
        while(total>=k){
            cur = prev.next;
            next = cur.next;
            for(int i=0;i<k;i++){
                cur.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = cur.next;
            }
            total -=k;
            prev = cur ;
        }
        return dummy.next;
    }
}
