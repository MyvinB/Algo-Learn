
public class LeftRotateLinkedListLC61 {
	  static ListNode setNodes(ListNode l1,int val){
      	l1.next=new ListNode(val);
      	l1=l1.next;
      	return l1;
  }
	
	  static ListNode cyclicwayRotate(ListNode head,int k,char direction){
		  ListNode first=head;
		  ListNode last=head;
		  int totalcount=1;
		  int n;
		  //assigning the last pointer to last
		  while(last.next!=null){
			  last=last.next;
			  ++totalcount; 
		  }
		  //making it cyclic
		  last.next=first;
		  
		  
		  
		  if(k>=totalcount)k=k%totalcount;
		  if(direction=='L')n=k;
		  else if(direction=='R')n=totalcount-k;
		  else throw new IllegalArgumentException("Choose L or R");
		  //running both the pointers to k and keeping and setting the last pointer to null and returning the first pointer
		  for(int i=1;i<=n;i++){
			  first=first.next;
			  last=last.next;
			  
		  }
		  last.next=null;
		  return first;
		  
	  }

	
public static void main(String[] args) {
	ListNode l1=new ListNode(0);
	ListNode head1=l1;
	l1=setNodes(l1, 1);
	l1=setNodes(l1, 2);
	l1=setNodes(l1, 3);
	l1=setNodes(l1, 4);
	l1=setNodes(l1, 5);

	head1=head1.next;
	ListNode temp=head1;
	while(temp!=null){
		System.out.print(temp.val+"->");
		temp=temp.next;
	}
	System.out.println();

	temp=cyclicwayRotate(head1, 2,'L');
	while(temp!=null){
		System.out.print(temp.val+"->");
		temp=temp.next;
	}

}


}
