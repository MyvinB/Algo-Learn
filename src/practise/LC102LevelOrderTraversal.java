package practise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC102LevelOrderTraversal {

    class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(){

        }
        TreeNode(int val,TreeNode left ,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root==null) return list;
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            while(size-- !=0){
                TreeNode node = q.poll();
                if(node.left !=null) q.add(node.left);
                if(node.right!= null) q.add(node.right);
                level.add(node.val);
            }
            list.add(level);
        }
        return list;
    }

}
