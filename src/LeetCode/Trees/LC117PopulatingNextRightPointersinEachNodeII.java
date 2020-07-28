package LeetCode.Trees;/*
 @author Myvin Barboza
 28/07/20 6:54 PM 
 */

public class LC117PopulatingNextRightPointersinEachNodeII {
    public Node connect(Node root) {
        Node head=root;
        Node dummy=new Node(0);
        Node pre=dummy;
        while(root!=null){
            if(root.left!=null){
                pre.next=root.left;
                pre=pre.next;
            }
            if(root.right!=null){
                pre.next=root.right;
                pre=pre.next;
            }
            root=root.next;
            if(root==null){
                pre=dummy;
                root=dummy.next;
                dummy.next=null;
            }
        }
        return head;
    }

}
