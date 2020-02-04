/*Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3*/
public class RemoveDuplicatesfromSortedListIILC82 {
	  	
	
	
		static ListNode deleteDuplicates(ListNode head) {
			ListNode dummy=new ListNode(0);
			ListNode fast=head;
			ListNode slow=dummy;
			slow.next=fast;
			while(fast!=null){
				while(fast.next!=null&&fast.val==fast.next.val){
					fast=fast.next;
				}
				if(slow.next!=fast){
					slow.next=fast.next;
					fast=slow.next;
				}
				else{
					slow=slow.next;
					fast=fast.next;
				}
			}
			return dummy.next;
	       
	    }
	
	
	
	
	public static void main(String[] args) {
		ListNode n=new ListNode(1);
		n.next=new ListNode(2);
		n.next.next=new ListNode(2);
		n.next.next.next=new ListNode(3);
		n.next.next.next.next=new ListNode(3);
		n.next.next.next.next.next=new ListNode(4);

		n=deleteDuplicates(n);
		while(n!=null){
			System.out.println(n.val);
			n=n.next;
		}

	}
}
