package LeetCodeChallenge.Aug2022.TreePractise;

import TopicWise2022.Tree.common.TreeNode;

public class LC99 {

    public static void main(String[] args) {

    }

    TreeNode prev = null;
    TreeNode one = null;
    TreeNode two = null;
    public void recoverTree(TreeNode root) {
        inOrder(root);
        int temp = one.val;
        one.val = two.val;
        two.val = temp;

    }
    public void inOrder(TreeNode cur){
        if(cur==null) return;
        inOrder(cur.left);
        if(prev!=null && prev.val>cur.val){
            if(one==null){
                one = prev;
            }
            two=cur;
        }
        prev = cur;
        inOrder(cur.right);
    }
}
