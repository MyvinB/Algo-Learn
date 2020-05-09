package LeetCode.LinkedList;

import java.util.Arrays;

public class MergeSortedLC21andLC23{
	  static ListNode setNodes(ListNode l1,int val){
	        	l1.next=new ListNode(val);
	        	l1=l1.next;
	        	return l1;
	    }
	  ///Improved function where actually working with listnode and not creating new ListNode and storing in dummy variable just playing with pointers
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

	static ListNode mergeKLists(ListNode[] lists) {
		if(lists.length==0)return null;
		if(lists.length==1)return lists[0];
		if(lists.length==2)return mergeTwoLists(lists[0],lists[1]);
		else{
			int mid=lists.length/2;
			ListNode firsthalf=mergeKLists(Arrays.copyOfRange(lists,0,mid));
			ListNode secondhalf=mergeKLists(Arrays.copyOfRange(lists,mid,lists.length));
			return  mergeTwoLists(firsthalf,secondhalf);
		}

	}
		public static void main(String[] args) {
			ListNode l1=new ListNode(0);
			ListNode head1=l1;
			l1=setNodes(l1, 1);
			l1=setNodes(l1,4);
			l1=setNodes(l1,5);
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
			head2=head2.next;
			temp=head2;
			while(temp!=null){
				System.out.print(temp.val+"->");
				temp=temp.next;
			}
			System.out.println();
			ListNode l3=new ListNode(0);
			ListNode head3=l3;
			l3=setNodes(l3, 2);
			l3=setNodes(l3,6);
			head3=head3.next;
			temp=head3;
			while(temp!=null){
				System.out.print(temp.val+"->");
				temp=temp.next;
			}
			System.out.println();
			ListNode[] list={head1,head2,head3};
			ListNode headf=mergeKLists(list);
			System.out.println("final");
			 temp=headf;
				while(temp!=null){
					System.out.print(temp.val+"->");
					temp=temp.next;
				}
			
			
		}
}
