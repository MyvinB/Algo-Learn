package LeetCodeChallenge.Aug2022.TreePractise;

import TopicWise2022.Tree.common.TreeNode;

public class LC124 {

    public static void main(String[] args) {

    }

    public int maxPathSum(TreeNode root) {
        int[] max = new int[]{Integer.MIN_VALUE};
        maxSum(root,max);
        return max[0];
    }

    public int maxSum(TreeNode root,int[] max){
        if(root==null) return 0;
        int lmax = Math.max(maxSum(root.left,max),0);
        int rmax = Math.max(maxSum(root.right,max),0);
        max[0] = Math.max(max[0],lmax+rmax+root.val);
        return root.val+Math.max(lmax,rmax);
    }
}
