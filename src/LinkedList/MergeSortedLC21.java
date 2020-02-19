
public class MergeSortedLC21 {
	  static ListNode setNodes(ListNode l1,int val){
	        	l1.next=new ListNode(val);
	        	l1=l1.next;
	        	return l1;
	    }
	  ///Improved function where actually working with listnode and not creating new ListNode and storing in dummy variable just
	//playing with pointers
	  ///Duration 1hr 30 min
	static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy=new ListNode(0);
		ListNode head=dummy;
		//
		while(true){
			if(l1==null){
				dummy.next=l2;break;
			}
			else if(l2==null){
				dummy.next=l1;break;
			}
			else if(l1.val<=l2.val){
				dummy.next=l1;l1=l1.next;
			}
			else{
				dummy.next=l2;l2=l2.next;
			}
			dummy=dummy.next;
		}
		return head.next;
	
	}
		public static void main(String[] args) {
			ListNode l1=new ListNode(0);
			ListNode head1=l1;
			l1=setNodes(l1, 1);
			l1=setNodes(l1,2);
			l1=setNodes(l1,4);
			head1=head1.next;
			ListNode temp=head1;
			while(temp!=null){
				System.out.print(temp.val+"->");
				temp=temp.next;
			}
			System.out.println();
			ListNode l2=new ListNode(0);
			ListNode head2=l2;
			l2=setNodes(l2, 1);
			l2=setNodes(l2,3);
			l2=setNodes(l2,4);
			l2=setNodes(l2,5);
			l2=setNodes(l2,6);
			head2=head2.next;
			temp=head2;
			while(temp!=null){
				System.out.print(temp.val+"->");
				temp=temp.next;
			}
			
		ListNode headf=mergeTwoLists(head1, head2);
		System.out.println();
		temp=headf;
		while(temp!=null){
			System.out.print(temp.val+"->");
			temp=temp.next;
		}
			
		}
}
