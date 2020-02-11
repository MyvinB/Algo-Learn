/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 /*
  Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

 */
class AddTwoNumbersLC2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1=l1;
        ListNode temp2=l2;
        ListNode dummy=new ListNode(0);
        ListNode head=dummy;
        int sum=0,carry=0;
        while(temp1!=null||temp2!=null){
     
            if(temp1!=null)sum=sum+temp1.val;
            if(temp2!=null)sum=sum+temp2.val;
            sum=sum+carry;
            carry=0;
            ListNode n=null;
            if(sum>9){
                n=new ListNode(sum%10);
                carry=sum/10;
            }
            else{
                n=new ListNode(sum);
            }
            dummy.next=n;
            dummy=dummy.next;
            
            if(temp1!=null)temp1=temp1.next;
            if(temp2!=null)temp2=temp2.next;
            sum=0;
            
        }
        if(carry!=0){
            dummy.next=new ListNode(carry);
        }
    return head.next;
    }
    
}
