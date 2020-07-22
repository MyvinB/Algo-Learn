package practise;/*
 @author Myvin Barboza
 21/07/20 5:28 PM 
 */

import java.util.List;

public class LC61RotateList {
        //Definition for singly-linked list.
      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    //much better 100%
    public ListNode rotateRightB(ListNode head, int k) {
        if(head==null) return head;
        ListNode first=head;
        ListNode last=head;
        int totalcount=1;
        while(last.next!=null){
            last=last.next;
            totalcount++;
        }
        last.next=first;
        k=k%totalcount;
        for(int i=1;i<=totalcount-k;i++){
            first=first.next;
            last=last.next;
        }
        last.next=null;
        return first;

    }

    static ListNode rotateRight(ListNode head, int k) {
        if(head==null) return head;
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode fast=dummy;
        ListNode slow=dummy;
        int i=0;
        for(i=0;fast.next!=null;i++)
            fast=fast.next;
        for(int j=i-k%i;j>0;j--)
            slow=slow.next;
        fast.next=dummy.next;
        dummy.next=slow.next;
        //final end of skow
        slow.next=null;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n=new ListNode(1);
        n.next=new ListNode(2);
        n.next.next=new ListNode(3);
        n.next.next.next=new ListNode(4);
        n.next.next.next.next=new ListNode(5);
        ListNode t=rotateRight(n,2);
    }
}
