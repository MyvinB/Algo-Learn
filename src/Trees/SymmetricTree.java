package Trees;

import java.util.Stack;

/*
 @author Myvin Barboza
 14/04/20 10:02 AM 
 */public class SymmetricTree {
     //recursively 100% faster
    static boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
    //iterative ret
        //return iterative(root);
        return isSymmetricRecurs(root.left,root.right);
    }

    static boolean iterative(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while(!stack.isEmpty()){
            TreeNode n1=stack.pop();
            TreeNode n2=stack.pop();
            if(n1==null && n2==null) continue;
            if(n1==null ||n2==null ||n1.val!=n2.val) return false;
            stack.push(n1.left);
            stack.push(n2.right);
            stack.push(n1.right);
            stack.push(n2.left);
        }
        return true;
    }

    static boolean isSymmetricRecurs(TreeNode left,TreeNode right){
        if( left==null && right==null) return true;
        if(right==null||left==null||left.val!=right.val) return false;
        return isSymmetricRecurs(left.left,right.right) && isSymmetricRecurs(left.right,right.left);
    }


     public static void main(String[] args) {
        TreeNode a=new TreeNode(1);
        a.left=new TreeNode(2);
        a.right=new TreeNode(2);
//        a.right.right=new TreeNode(3);
//        a.left.right=new TreeNode(3);
         System.out.println(isSymmetric(a));


    }
}