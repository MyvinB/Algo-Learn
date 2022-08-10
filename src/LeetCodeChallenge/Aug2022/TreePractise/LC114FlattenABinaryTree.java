package LeetCodeChallenge.Aug2022.TreePractise;

import TopicWise2022.Tree.common.TreeNode;

import java.util.Stack;

public class LC114FlattenABinaryTree {

    public static void main(String[] args) {

    }


    //Easiest Method and very intuitive blah
    public void flatten1(TreeNode root) {
        if(root==null) return;
        TreeNode cur = null;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            cur = stack.pop();
            if(cur.right!=null) stack.add(cur.right);
            if(cur.left!=null) stack.add(cur.left);
            if(!stack.isEmpty())cur.right = stack.peek();
            cur.left = null;
        }
    }

    //Recursively using heap space
    TreeNode prev = null;
    public void flatten(TreeNode root){
        if(root==null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    //Iteratively using right stuff
    public void flattenA(TreeNode root){
        TreeNode cur = root;
        while(cur!=null){
            if(cur.left!=null){
                TreeNode prev = cur.left;
                while(prev.right!=null) prev = prev.right;
                prev.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }

}
