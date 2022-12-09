package LeetCodeChallenge.December2022;

import TopicWise2022.Tree.common.TreeNode;

public class LC1026 {

    public static void main(String[] args) {

    }

    public int maxAncestorDiff(TreeNode root) {
        return dfs(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
    }


    public int dfs(TreeNode root,int min,int max){
        if(root==null) return max-min;
        max = Integer.max(max,root.val);
        min = Integer.min(min,root.val);
        return Math.max(dfs(root.left,min,max),dfs(root.right,min,max));
    }
}
