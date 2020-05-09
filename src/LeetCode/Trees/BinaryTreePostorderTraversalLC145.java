package LeetCode.Trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 @author Myvin Barboza
 29/04/20 12:50 PM 
 */public class BinaryTreePostorderTraversalLC145 {

    static List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list=new LinkedList<>();
        if(root==null) return list;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode n=stack.pop();
            list.addFirst(n.val);
            if(n.left!=null){
                stack.push(n.left);
            }
            if(n.right!=null){
                stack.push(n.right);
            }

        }
        return list;
    }


     public static void main(String[] args) {
         TreeNode n=new TreeNode(1);
         n.left=new TreeNode(2);
         n.right=new TreeNode(3);
         n.left.left=new TreeNode(4);
         n.left.right=new TreeNode(5);
         System.out.println(postorderTraversal(n));

     }
 }