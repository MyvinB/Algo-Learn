package LeetCode.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 @author Myvin Barboza
 25/04/20 8:45 AM 
 */public class BinaryTreeLevelOrderTraversalLC102 {

    //bfs
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> que=new LinkedList();
        List<List<Integer>> list=new ArrayList<>();
        que.add(root);
        while(!que.isEmpty()){
            List<Integer> temp=new ArrayList<>();
            int size=que.size();
            for (int i = 0; i <size ; i++) {
                if(que.peek().left!=null)que.offer(que.peek().left);
                if(que.peek().right!=null)que.offer(que.peek().right);
                temp.add(que.poll().val);
            }
            list.add(new ArrayList<>(temp));

        }
    return list;

    }
    //dfs
    public List<List<Integer>> dfslevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        helper(root,res,0);

        return res;
    }


    static void helper(TreeNode root, List<List<Integer>> list,int height) {
    if(root==null)return;
    if(height==list.size()){
        list.add(new ArrayList<>());
    }
    list.get(height).add(root.val);
    helper(root.left,list,height+1);
        helper(root.right,list,height+1);
    }

     public static void main(String[] args) {

    }
}