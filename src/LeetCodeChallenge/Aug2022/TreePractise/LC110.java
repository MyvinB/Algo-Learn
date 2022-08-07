package LeetCodeChallenge.Aug2022.TreePractise;

import TopicWise2022.Tree.common.TreeNode;

public class LC110 {

    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {
        if(maxHeight(root)==-1) return false;
        else return true;
    }

    public int maxHeight(TreeNode root){
        if(root==null) return 0;
        int lf = maxHeight(root.left);
        int rh = maxHeight(root.right);
        if(lf==-1 || rh == -1) return -1;
        if(Math.abs(lf-rh)>1) return -1;
        return 1+Math.max(lf,rh);
    }


}
