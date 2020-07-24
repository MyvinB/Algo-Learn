package LeetCode.Trees;/*
 @author Myvin Barboza
 24/07/20 5:37 PM 
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC515FindLargestValueinEachTreeRow {
    public static void main(String[] args) {

    }
    //dfs is faster
    public List<Integer> largestValuesDFS(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        dfs(root, res, 0);
        return res;
    }

    static void dfs(TreeNode root,List<Integer> res,int level){
        if(root==null) return;
        if(level==res.size()){
            res.add(root.val);
        }else{
            res.set(level,Math.max(res.get(level),root.val));
        }
        dfs(root.left,res,level+1);
        dfs(root.right,res,level+1);
    }

    //bfs
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();

        queue.offer(root);
        List<Integer> list=new ArrayList<>();
        if(root==null) return list;
        while(!queue.isEmpty()){
            int size=queue.size();
            int max=Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode cur=queue.poll();
                max=Math.max(cur.val,max);
                if(cur.left!=null)queue.offer(cur.left);
                if(cur.right!=null)queue.offer(cur.right);
            }
            list.add(max);

        }
        return list;
    }

}
