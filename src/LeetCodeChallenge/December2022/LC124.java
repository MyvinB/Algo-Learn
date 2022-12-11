package LeetCodeChallenge.December2022;

import TopicWise2022.Tree.common.TreeNode;

public class LC124 {


    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    int max= Integer.MIN_VALUE;
    public int dfs(TreeNode root){
        if(root==null) return 0;
        int left = Math.max(dfs(root.left),0);
        int right = Math.max(dfs(root.right),0);
        int sum = left+right+root.val;
        //sum here takes care of nodal path that is we consider left root and right as the path
        max = Math.max(max,sum);
        //now when we are condering a path we choose the maximum between left and right as we cannot take both left and right
        return root.val +Math.max(left,right);
    }
}
