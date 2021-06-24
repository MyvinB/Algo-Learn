package LeetCodeChallenge.JUNE2021;

import java.util.LinkedList;

public class LC92ReverseLinkedListII {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        //edge case no need for reverse
        if(left==right){
            return head;
        }

        ListNode temp = head;
        ListNode next = null;
        ListNode l = null;
        ListNode r = null;
        int i = 1;
        while (temp != null) {
            if (i == left) {
                l = temp;
            }
            if (i == right) {
                r = temp;
            }
            temp = temp.next;
            i++;
        }
        ListNode prev = null;
        temp = head;
        while (temp != l) {
            prev = temp;
            temp = temp.next;
        }

        if (prev != null) {
            prev.next = r;
        } else {
            head=r;
        }
        next=temp.next;
        while(temp!=r){
            prev=temp;
            temp=next;
            next=next.next;
            temp.next=prev;
        }
        l.next=next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int left = 2;
        int right = 4;
        reverseBetween(head,left,right);
    }
}
