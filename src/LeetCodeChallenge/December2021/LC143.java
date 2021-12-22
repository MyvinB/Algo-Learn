package LeetCodeChallenge.December2021;

import LeetCodeChallenge.Requirements;

import java.util.List;

/**
 * @author mmichaelbarboza
 * on 10:09 PM 12/22/2021
 */
public class LC143 {
    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }


    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(5);
        reorderList(a);
        while(a!=null){
            System.out.print(a.val+"->");
            a = a.next;
        }

    }

    public static void reorderList(ListNode head) {
        if(head==null || head.next == null){
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode slowPrev = null;
        while(fast!=null && fast.next!=null){
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        slowPrev.next = null;
        ListNode it2 = reverseList(slow);
        ListNode mergeHead = new ListNode(0);
        ListNode it = mergeHead;
        ListNode it1 = head;

        while( it1!=null && it2!=null ){
            ListNode it1Next = it1.next;
            it.next = it1;
            it1 = it1.next;

            it = it.next;

            ListNode it2Next = it2.next;
            it.next = it2;
            it2 = it2Next;

            it = it.next;
        }
        head = mergeHead.next;
    }

    public static ListNode reverseList(ListNode node){
        ListNode prev = null;
        ListNode cur = node;

        while(cur!=null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}
