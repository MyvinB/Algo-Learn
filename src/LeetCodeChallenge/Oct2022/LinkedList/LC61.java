package LeetCodeChallenge.Oct2022.LinkedList;

import TopicWise2022.common.ListNode;

public class LC61 {

    public static void main(String[] args) {

    }

    public ListNode rotateRight(ListNode head, int k) {
        if(k==0 || head==null) return head;
        //Calculate to do modulo do not want useless operations
        ListNode cur = head,temp= head;
        int totalCount = 0;
        while(temp.next!=null){
            totalCount++;
            temp = temp.next;
        }
        //since  the last one is not counted
        totalCount++;
        //Making it circular
        temp.next = head;
        //steps avoid useless rotations
        if(k>=totalCount) k =k%totalCount;
        //Get the count to traverse from forward
        k = totalCount -k;
        //Get previous node before
        for(int i=1;i<k;i++){
            cur = cur.next;
        }
        head = cur.next;
        cur.next = null;
        return head;
    }
}
