package LeetCode.LinkedList;
/*
 @author Myvin Barboza
 12/06/20 10:40 AM

 */

  /*
 Understanding
    Similar idea to yours with explanation.

For example,

list = 1 -> 2 -> 3 -> 4 -> 5, k = 3

    Use a dummy head to simplify operations.

Dummy -> 1 -> 2 -> 3 -> 4 -> 5

    Use three pointers. The operation is similar to Leetcode#92 Reverse Linked List II.

    The pointer n will go k steps further.
    (If there are no k nodes further, it means we don't have to reverse these k nodes. ==> Stop. )
    The pointer p is always at the fixed position in this for-loop.
    The pointer c = p.next, which means the current node we want to move.
    The pointer start means the starting node for the next loop.

Dummy -> 1 -> 2 -> 3 -> 4 -> 5
   p     c         n
         start

Dummy -> 2 -> 3 -> 1 -> 4 -> 5
   p     c    n    start

Dummy -> 3 -> 2 -> 1 -> 4 -> 5
   p     c         start
         n

    */

public class LC25ReverseNodesInkGroup {


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(0),start=dummy;
        dummy.next=head;
        ListNode p,n,c;
        while(true){
            p=start;n=p;
            start=p.next;
            for(int i=0;i<k && n!=null; i++)n=n.next;
            //if we cant find k elements from the current break we are done
            if(n==null) break;
            //k-1 cause the first element just points to the next of k value then movement need to
            //be done for the rest
            for(int i=0;i<k-1;i++){
                    c=p.next;
                    p.next=c.next;
                    c.next=n.next;
                    n.next=c;
            }
        }
        return dummy.next;

    }



    public static void main(String[] args) {

    }
}