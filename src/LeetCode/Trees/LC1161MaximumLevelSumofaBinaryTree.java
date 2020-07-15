package LeetCode.Trees;/*
 @author Myvin Barboza
 15/07/20 11:21 AM 
 */

import java.util.LinkedList;
import java.util.Queue;

public class LC1161MaximumLevelSumofaBinaryTree {
    public int maxLevelSum(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int max=0;
        int level=1;
        int maxlevel=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            int sum=0;

            for(int i=0;i<size;i++){
                TreeNode cur=queue.poll();
                sum+=cur.val;
                if(cur.left!=null) queue.add(cur.left);
                if(cur.right!=null) queue.add(cur.right);
            }
            // System.out.println(sum +" "+level);
            if(sum>max) { max=sum; maxlevel=level;}
            level++;
        }
        return maxlevel;

    }

}
