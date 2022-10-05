package LeetCodeChallenge.Oct2022.LinkedList;

import TopicWise2022.common.ListNode;

public class LC19RemoveNthNode {

    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        //Move pointer fast to simulate end at the back
        for(int i=1;i<=n;i++){
            fast = fast.next;
        }
        //if the fast is already null means we have to deleted the first element
        if(fast==null) return head.next;
        //Moving both the pointers together will keep the slow elem just before the elm to be deleted fast.next helps here
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
