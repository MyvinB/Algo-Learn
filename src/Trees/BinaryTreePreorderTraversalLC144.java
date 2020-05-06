package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 @author Myvin Barboza
 29/04/20 12:02 PM 
 */public class BinaryTreePreorderTraversalLC144 {

    static List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res=new ArrayList<>();
    if(root==null) return res;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode n=stack.pop();
            res.add(n.val);
            if(n.right!=null)stack.push(n.right);
            if(n.left!=null)stack.push(n.left);
        }
    return res;
    }


     public static void main(String[] args) {
         TreeNode n=new TreeNode(1);
         n.left=new TreeNode(2);
         n.right=new TreeNode(3);
         n.left.left=new TreeNode(4);
         n.left.right=new TreeNode(5);
         System.out.println(preorderTraversal(n));
    }
}