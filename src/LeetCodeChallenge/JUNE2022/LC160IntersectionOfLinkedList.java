package LeetCodeChallenge.JUNE2022;

import TopicWise2022.common.ListNode;

public class LC160IntersectionOfLinkedList {
    public static void main(String[] args) {

    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        while(A!=B){
            A = A!=null?A.next:headB;
            B = B!=null?B.next:headA;
        }
        return A;
    }
}
