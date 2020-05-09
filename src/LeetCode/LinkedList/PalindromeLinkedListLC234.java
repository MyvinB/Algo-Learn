package LeetCode.LinkedList;/*Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true*/

import java.util.Stack;







public class PalindromeLinkedListLC234 {

    static boolean isPalindromeRev(ListNode head) {

        ListNode temp=head;
        String s="";
        String p="";

        ListNode current=head;
        ListNode prev=null;
        ListNode next=null;

        while(temp!=null){
            s=s+temp.val;
            temp=temp.next;
        }


        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }

        head=prev;
        temp=prev;
        while(temp!=next){
            p=p+temp.val;
            temp=temp.next;
        }
        if(s.equals(p))return true;
        else return false;

    }


    ///store in stack since it follows first in last out its easily reversed
    static boolean isPalindrome(ListNode head) {
    Stack<Integer> s=new Stack();
    ListNode temp=head;
    while(temp!=null){
        s.push(temp.val);
        temp=temp.next;
    }
    temp=head;
    while(temp!=null){
            if(s.pop()!=temp.val)return false;
            temp=temp.next;
    }
    return true;

    }

    public static void main(String[] args) {
        ListNode n=new ListNode(1);
        n.next=new ListNode(4);
        n.next.next=new ListNode(2);
        n.next.next.next=new ListNode(6);
        n.next.next.next.next=new ListNode(9);
        System.out.println(isPalindrome(n));
        System.out.println(isPalindromeRev(n));
    }
}
