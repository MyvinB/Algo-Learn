package LeetCodeChallenge.Oct2022.Daily;

import TopicWise2022.Tree.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC623 {


    public static void main(String[] args) {

    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode n = new TreeNode(val);
            n.left = root;
            return  n;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for(int i=1;i<=depth-2;i++){
            int size = queue.size();
            // System.out.println("size -->"+size+"i--> "+i);
            while(size-->0){
                TreeNode cur = queue.poll();
                // System.out.println(cur.val +" poping out");
                if(cur.left!=null){
                    queue.add(cur.left);
                }
                if(cur.right!=null){
                    queue.add(cur.right);
                }
            }
        }

        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            TreeNode tmpLeft = cur.left;
            TreeNode tmpRight = cur.right;
            cur.left = new TreeNode(val);
            cur.right = new TreeNode(val);
            cur.left.left = tmpLeft;
            cur.right.right = tmpRight;
        }
        return root;
    }
}
