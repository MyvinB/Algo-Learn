package LeetCodeChallenge.Sep2022.DailyChallenege;

import TopicWise2022.Tree.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC637 {

    public static void main(String[] args) {

    }

    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Double> res = new ArrayList<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            double sum = 0;
            int n = size;
            while(size-->0){
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            res.add(sum/n);
        }
        return res;
    }
}
