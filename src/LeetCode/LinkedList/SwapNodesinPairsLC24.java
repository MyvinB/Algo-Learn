package LeetCode.LinkedList;

/*
 @author Myvin Barboza
 31/03/20 3:29 PM 
 */public class SwapNodesinPairsLC24 {

    static ListNode swapPairs(ListNode head) {
        if(head==null) return  head;
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null){
            int temp;
            temp=slow.val;
            slow.val=fast.val;
            fast.val=temp;
            if(fast.next==null)break;
            slow=fast.next;
            fast=slow.next;
        }

       return head;

    }
///without swapping values this is what is told to do
    static ListNode swapPair(ListNode head){
       if(head==null ||head.next==null)return head;
        ListNode newHead=head.next,a=head,b=a.next,pre=null;

        while(a!=null && b!=null){
            a.next=b.next;
            b.next=a;
            if(pre!=null) pre.next=b;
            if(a.next==null) break;
            b=a.next.next;
            pre=a;
            a=a.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
    ListNode head=new ListNode(1);
    head.next=new ListNode(2);
    head.next.next=new ListNode(3);
    head.next.next.next=new ListNode(4);

    head=swapPair(head);
    while(head!=null){
        System.out.println(head.val);
        head=head.next;
    }


    }
}