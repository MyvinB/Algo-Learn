package TopicWise2022.LinkedList;

import TopicWise2022.common.ListNode;

public class LC61RotateRight {

    public static void main(String[] args) {

    }

    public ListNode rotateRight(ListNode head, int k) {
        ListNode first = head;
        ListNode last = head;
        int total = 0;
        while(last.next!=null){
            total++;
            last = last.next;
        }
        k%=total;
        last.next = first;
        for(int i=1;i<=total-k;i++){
            first = first.next;
            last = last.next;
        }
        last.next = null;
        return first;


    }
}
