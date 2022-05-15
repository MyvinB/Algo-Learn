package LeetCodeChallenge.MAY2022;

import TopicWise2022.Tree.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC1302 {

    public static void main(String[] args) {

    }

    public int deepestLeavesSumQueue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int totalSum = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            totalSum = 0;
            while(size-->0){
                TreeNode node = queue.poll();
                totalSum+= node.val;
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
        }
        return totalSum;
    }
    private int maxLevel = 0;
    private int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        if(root==null) return 0;
        dfs(root,0);
        return sum;
    }

    private void dfs(TreeNode root,int level){
        if(root == null) return;
        if(level>maxLevel){
            maxLevel = level;
            sum = 0;
        }
        if(level==maxLevel){
            sum+=root.val;
        }
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
}
