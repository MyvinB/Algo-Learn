package LinkedList;/*
 @author Myvin Barboza
 3/9/2020 4:48 PM
 */

public class IntersectionOfTwoLinkedListsLC160 {

    static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A=headA;
        ListNode B=headB;

        while(A!=B){
            A=A!=null?A.next:headB;
            B=B!=null?B.next:headA;
        }
        return A;
    }

    public static void main(String[] args) {
    ListNode a=new ListNode(2);
    a.next=new ListNode(6);
    a.next.next=new ListNode(4);

    ListNode b=new ListNode(1);
    b.next=new ListNode(5);
     getIntersectionNode(a,b);

    }
}
