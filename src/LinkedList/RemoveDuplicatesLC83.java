package LinkedList;

/*Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3*/

public class RemoveDuplicatesLC83 {

	 static ListNode deleteDuplicates(ListNode head) {
	        if(head==null)return null;
		 ListNode current =head;
	        ListNode forward=head.next;

	        
	        while(forward!=null){
	        
	       if(current.val==forward.val){
	    	   forward=forward.next;
	       }
	       else{
	           current.next=forward;
		       current=current.next;
		       forward=current.next;
	       }
	        }
	        current.next=forward;
	        
	        return head;
	    }
	
	
	public static void main(String[] args) {
	ListNode n=new ListNode(1);
	n.next=new ListNode(1);
	n.next.next=new ListNode(2);
	n.next.next.next=new ListNode(3);
	n.next.next.next.next=new ListNode(3);
	n=deleteDuplicates(n);
	while(n!=null){
		System.out.println(n.val);
		n=n.next;
	}
	}
}
