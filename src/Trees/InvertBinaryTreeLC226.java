package Trees;

import java.util.Stack;

/*
 @author Myvin Barboza
 18/04/20 3:06 PM 
 */
public class InvertBinaryTreeLC226 {

    static TreeNode invertTree(TreeNode root) {
    if(root==null)return null;
        TreeNode n = new TreeNode(root.val);
    n.left=invertTree(root.right);
            n.right=invertTree(root.left);
            return n;
    }



    public static void main(String[] args) {

    }
 }