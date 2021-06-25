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

    public static ListNode reverseBetweenR(ListNode head, int m, int n) {
        ListNode dummy= new ListNode(0);
        dummy.next= head;
        int i=1;
        ListNode startNode = dummy;
        while(i<m){
            startNode=startNode.next;
            i++;
        }
        if(startNode ==null ||startNode.next ==null) return head;
        ListNode pre = startNode.next;
        ListNode cur=pre.next;
        while(i<n){
            pre.next= cur.next;
            cur.next = startNode.next;
            startNode.next = cur;
            cur= pre.next;
            i++;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int left = 2;
        int right = 4;
        head = reverseBetweenR(head,left,right);
        while(head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}
