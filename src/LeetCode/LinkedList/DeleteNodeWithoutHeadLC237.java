package LeetCode.LinkedList;/*
 @author Myvin Barboza
 2/26/2020 3:22 PM
 */

public class DeleteNodeWithoutHeadLC237 {
    static void deleteNode(ListNode node) {
        ListNode temp=node.next;
        node.val=temp.val;
        node.next=temp.next;
    }

    public static void main(String[] args) {

        ListNode n=new ListNode(1);
        n.next=new ListNode(2);
        //temp pointer delete this node
        ListNode  temp=n.next.next=new ListNode(3);
        n.next.next.next=new ListNode(4);
        n.next.next.next.next=new ListNode(5);
        deleteNode(temp);
        while(n!=null){
            System.out.println(n.val
            );
            n=n.next;
        }
    }
}
