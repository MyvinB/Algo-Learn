package LeetCodeChallenge.Oct2022.Daily;

import TopicWise2022.Tree.common.TreeNode;

public class LC112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root,0,targetSum);
    }

    public boolean dfs(TreeNode root,int sum, int targetSum){
        if(root==null) return false;
        if(sum+root.val==targetSum && root.left==null && root.right==null) return true;
        return dfs(root.left,sum+root.val,targetSum) || dfs(root.right,sum+root.val,targetSum);
    }
}
