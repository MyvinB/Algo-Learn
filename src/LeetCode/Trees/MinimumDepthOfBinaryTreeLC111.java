package LeetCode.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTreeLC111 {

    static int minDepth(Node root) {
        if(root==null)return 0;
        if(root.left==null&&root.right==null)return 1;
        if(root.left==null)return 1+minDepth(root.right);
        if(root.right==null)return 1+minDepth(root.left);
        int left=minDepth(root.left);
        int right=minDepth(root.right);
        return Math.min(left,right)+1;
    }
    /*
    Simple bfs count levels increment just return depth when we reach leaf node
     */

    static  int minDepthNew(TreeNode root){
        if(root==null) return 0;
        int depth=1;
        Queue<TreeNode> queue =new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node= queue.poll();
                if(node.left==null && node.right==null)
                    return depth;
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
            depth++;
        }
        return -1;
    }
    
    public static void main(String[] args) {
        Node root=new Node(10);
        root.right=new Node(1);
        System.out.println(minDepth(root));

    }
}
