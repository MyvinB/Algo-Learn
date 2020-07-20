package LeetCode.Trees;/*
 @author Myvin Barboza
 20/07/20 9:14 AM 
 */

import java.util.LinkedList;

public class LC109ConvertSortedListtoBinarySearchTree {

    static TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        return toBST(head,null);
    }
    static TreeNode toBST(ListNode head, ListNode tail){
        ListNode slow = head;
        ListNode fast = head;
        if(head==tail) return null;

        while(fast!=tail&&fast.next!=tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode thead = new TreeNode(slow.val);
        thead.left = toBST(head,slow);
        thead.right = toBST(slow.next,tail);
        return thead;
    }
    public static void main(String[] args) {
        ListNode n=new ListNode(10);
        n.next=new ListNode(-3);
        n.next.next=new ListNode(0);
        n.next.next.next=new ListNode(5);
        n.next.next.next.next=new ListNode(9);
        TreeNode t=sortedListToBST(n);

    }
}
