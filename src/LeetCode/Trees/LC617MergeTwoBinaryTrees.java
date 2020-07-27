package LeetCode.Trees;/*
 @author Myvin Barboza
 27/07/20 8:44 AM 
 */

public class LC617MergeTwoBinaryTrees {

    public static void main(String[] args) {
        TreeNode n=new TreeNode(1);
        n.left=new TreeNode(3);
        n.right=new TreeNode(2);
        n.left.left=new TreeNode(5);

        TreeNode n1=new TreeNode(2);
        n1.left=new TreeNode(1);
        n1.right=new TreeNode(3);
        n1.right.right=new TreeNode(7);
        n1.left.right=new TreeNode(4);
        mergeTrees(n,n1);
    }

   static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
       if (t1 == null) {
           return t2;
       }
       if (t2 == null) {
           return t1;
       }
       int newVal = t1.val + t2.val;
       t2.val = newVal;
       t2.left = mergeTrees(t1.left, t2.left);
       t2.right = mergeTrees(t1.right, t2.right);
       return t2;
    }



}
