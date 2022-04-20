package LeetCodeChallenge.APR2022;

import TopicWise2022.Tree.common.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author mmichaelbarboza
 * on 12:10 PM 4/19/2022
 * Time Taken:
 */
public class LC99 {
    public static void main(String[] args) {

    }
    TreeNode prev;
    TreeNode one;
    TreeNode two;
    public void recoverTree(TreeNode root) {
       inorder(root);
       int temp = one.val;
       one.val = two.val;
       two.val = temp;
    }

    private void inorder(TreeNode cur){
        if(cur==null) return;
        //DIp condition
        inorder(cur.left);
        if(prev!=null && prev.val>cur.val){
            if(one==null){
                one = prev;
            }
            two=cur;
        }
        prev=cur;
        inorder(cur.right);
    }
}
