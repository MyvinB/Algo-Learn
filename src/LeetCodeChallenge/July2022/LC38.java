package LeetCodeChallenge.July2022;

import TopicWise2022.Tree.common.TreeNode;
import TopicWise2022.common.ListNode;

public class LC38 {

    public static void main(String[] args) {

    }
    //Recursive Solution
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return ;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }


    //Iterative solution

    public void flatternIterative(TreeNode root){
        TreeNode cur = root;
        TreeNode prev = null;
        while(cur!=null){
            if(cur.left!=null){
                prev = cur.left;
                while(prev.right!=null){
                    prev = prev.right;
                }
                prev.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }

}
