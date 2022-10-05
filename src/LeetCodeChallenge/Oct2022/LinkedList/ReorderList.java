package LeetCodeChallenge.Oct2022.LinkedList;

import TopicWise2022.common.ListNode;

public class ReorderList {

    public static void main(String[] args) {

    }

    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        //Get to the middle of the linked list
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //reverse the linked list from node position
        ListNode middle = slow;
        //typical reverse
        ListNode prev = null;
        ListNode cur = slow.next;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        middle.next = null;
        //1 2 3 // 6 5 4

        ListNode p1 = head;
        ListNode p2 = prev;
        while(p1!=null){
            ListNode p1Next = p1.next;
            ListNode p2Next = p2.next;
            p1.next = p2; //1 -> 6
            p2.next = p1Next; //6 -> 2
            p1 = p1Next;// change to next pointer to the same thing
            p2 = p2Next;

        }
    }

}
