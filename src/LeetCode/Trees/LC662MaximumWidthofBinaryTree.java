package LeetCode.Trees;/*
 @author Myvin Barboza
 09/07/20 5:37 PM 
 */

import java.util.*;

public class LC662MaximumWidthofBinaryTree {

    //bfs faster
    public static int maximumWidthOfBinaryTreQueue(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        Queue<Integer> index=new LinkedList<>();
        queue.offer(root);
        index.offer(0);
       int max=0;
        while(!queue.isEmpty()){
            int size=queue.size();

            int start=0, end=0;

            for(int i=0;i<size;i++){
                TreeNode cur=queue.poll();
                int in=index.poll();
                if(i==0)start=in;
                if(i==size-1)end=in;
                if(cur.left!=null) { queue.offer(cur.left); index.offer(2*in);}
                if(cur.right!=null){ queue.offer(cur.right); index.offer(2*in+1); }
            }
            max=Math.max(max,end-start+1);
        }
        return max;
    }
            //dfs
     int max_width;
     HashMap<Integer,Integer> leftPosition;

    int widthOfBinaryTree(TreeNode root) {
            max_width=0;
            leftPosition=new HashMap<>();
            getWidth(root,0,1);
            return max_width;
    }

    void getWidth(TreeNode root,int depth,int position) {
        if(root==null) return;
        leftPosition.computeIfAbsent(depth,x->position);
        max_width=Math.max(max_width,position-leftPosition.get(depth)+1);
        getWidth(root.left,depth+1,position*2);
        getWidth(root.right,depth+1,position*2+1);

    }




    public static void main(String[] args) {
        LC662MaximumWidthofBinaryTree a=new LC662MaximumWidthofBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right=new TreeNode(3);
        root.right.right = new TreeNode(9);
        System.out.println(a.widthOfBinaryTree(root));
        System.out.println(maximumWidthOfBinaryTreQueue(root));
//        root.left.left.left = new TreeNode(6);
//        root.right.right.right = new TreeNode(7);
       // System.out.println(widthOfBinaryTree(root));
    }
}
