package Trees;

import java.util.LinkedList;
import java.util.Queue;
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


    static TreeNode invertTreeIterative(TreeNode root) {
        Queue<TreeNode> que=new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            TreeNode n=que.poll();
            if(n!=null){
                que.add(n.left);
                que.add(n.right);
                TreeNode temp=n.left;
                n.left=n.right;
                n.right=temp;
            }
        }
        return root;
    }



    public static void main(String[] args) {

    }
 }