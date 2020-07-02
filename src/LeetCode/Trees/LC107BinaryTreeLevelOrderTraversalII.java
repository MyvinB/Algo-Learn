package LeetCode.Trees;/*
 @author Myvin Barboza
 02/07/20 3:40 PM 
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC107BinaryTreeLevelOrderTraversalII {


    //bfs slower than dfs datastructures used
    //
    static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list =new ArrayList();
        if(root==null) return list;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> subList=new LinkedList<>();
            for(int i=0;i<size;i++){
                if(queue.peek().left!=null) queue.offer(queue.peek().left);
                if(queue.peek().right!=null)queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            //keeps going down
            list.add(0,subList);
        }

        return list;
    }











    //dfs way
    static List<List<Integer>> levelOrderBottomDfs(TreeNode root) {
        List<List<Integer>> list =new ArrayList();
        generate(root,0,list);
        return list;
    }

    static void generate(TreeNode root,int level,List<List<Integer>> list){

        if(root==null) return;
        if(level==list.size()){
            list.add(0,new LinkedList<Integer>());
        }

        generate(root.left,level+1,list);
        generate(root.right,level+1,list);
        list.get(list.size()-level-1).add(root.val);

    }

    public static void main(String[] args) {
        TreeNode n=new TreeNode(3);
        n.left=new TreeNode(9);
        n.right=new TreeNode(20);
        n.right.left=new TreeNode(15);
        n.right.right=new TreeNode(7);
        System.out.println(levelOrderBottom(n));
    }

}
