package LeetCode.Trees;/*
 @author Myvin Barboza
 3/16/2020 10:19 AM
 */

public class LinkedListInBinaryTreeLC1367 {

    static boolean res=false;
    static boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null && root == null) return true;
        else if (head == null || root == null) return false;
        helper(head,root);
        return res;
    }

    static void helper(ListNode head,TreeNode root){
        if(root==null|| res){
            return;
        }else if(head.val==root.val && traversal(head,root)){
            res=true;
        }
        helper(head,root.left);
        helper(head,root.right);
    }

    static boolean traversal(ListNode head ,TreeNode root){
        if(head==null)return true;
        else if(root==null)return false;
        return head.val==root.val && (traversal(head.next,root.left)||traversal(head.next,root.right));
    }


    public static void main(String[] args) {
        //head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
        //                       [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
        ListNode list1=new ListNode(1);
        ListNode list=new ListNode(4);
        list1.next=list;
        list.next=new ListNode(2);
        list.next.next=new ListNode(6);
        list.next.next.next=new ListNode(8);

        TreeNode tree=new TreeNode(1);
        //left
        tree.left=new TreeNode(4);
        tree.left.right=new TreeNode(2);
        tree.left.right.left=new TreeNode(1);

        //right
        tree.right=new TreeNode(4);
        tree.right.left=new TreeNode(2);
        tree.right.left.left=new TreeNode(6);
        tree.right.left.right=new TreeNode(8);
        tree.right.left.right.left=new TreeNode(1);
        tree.right.left.right.right=new TreeNode(3);

        System.out.println(isSubPath(list1,tree));

    }
}
