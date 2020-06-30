package LeetCode.Trees;/*
 @author Myvin Barboza
 30/06/20 9:38 AM 
 */

import java.util.Stack;

public class LC114FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {

    }
    //100 % faster
    TreeNode prev=null;
    public void flatten(TreeNode root) {
        if(root==null) return;

        flatten(root.right);
        flatten(root.left);
        root.right=prev;
        root.left=null;
        prev=root;
    }

    //using ds stack
    public void flattenStack(TreeNode root) {
        if(root==null) return;
        Stack<TreeNode> stack=new Stack();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode current=stack.pop();

            if(current.right!=null) stack.push(current.right);
            if(current.left!=null) stack.push(current.left);

            if(!stack.isEmpty()){
                current.right=stack.peek();
            }
            current.left=null;
        }
    }


}
