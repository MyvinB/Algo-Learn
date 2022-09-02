package LeetCodeChallenge.Sep2022.DailyChallenege;

import TopicWise2022.Tree.common.TreeNode;

import java.util.Stack;

public class LC1448CountGoodNodesInBinaryTree {

    public static void main(String[] args) {

    }


    public int goodNodes(TreeNode root) {
        if(root== null) return 0;
        int count = 1;
        count += dfs(root.left,root.val);
        count += dfs(root.right,root.val);
        return count;
    }

    public int dfs(TreeNode root,int currentMax){
        int amount =0;
        if(root==null) return 0;
        if(root.val>=currentMax){
            amount++;
            currentMax = root.val;
        }
        amount+= dfs(root.left,currentMax);
        amount+= dfs(root.right,currentMax);
        return amount;
    }
}
