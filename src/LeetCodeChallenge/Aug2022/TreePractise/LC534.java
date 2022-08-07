package LeetCodeChallenge.Aug2022.TreePractise;

import TopicWise2022.Tree.common.TreeNode;

public class LC534 {

    public static void main(String[] args) {

    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] dia = new int[]{-1};
        maxHeight(root,dia);
        return dia[0];
    }

    public int maxHeight(TreeNode root,int[] dia){
        if(root==null) return 0;
        int lf = maxHeight(root.left,dia);
        int rh = maxHeight(root.right,dia);
        dia[0] = Math.max(dia[0],lf+rh);
        return 1+Math.max(lf,rh);
    }
}
