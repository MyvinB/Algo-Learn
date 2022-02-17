package LeetCodeChallenge.Feb2022.practise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author mmichaelbarboza
 * on 9:19 AM 2/17/2022
 * Time Taken:
 */
public class LC637 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

        public static void main(String[] args) {

    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            double sum=0;
            for(int i=0;i<size;i++){
                TreeNode t = queue.poll();
                if(t.left!=null) queue.add(t.left);
                if(t.right!=null) queue.add(t.right);
                sum += t.val;
            }
            res.add(sum/size);
        }
        return res;
    }
}
