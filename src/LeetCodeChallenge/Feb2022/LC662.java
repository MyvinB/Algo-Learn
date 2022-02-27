package LeetCodeChallenge.Feb2022;

import java.util.LinkedList;
import java.util.Queue;

///
//  @author mmichaelbarboza
//  on 9:55 AM 2/27/2022
//  Time Taken:
// /
public class LC662 {


      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }


    public static void main(String[] args) {
        
    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> indexQ = new LinkedList<>();
        //IF zero based indexing take left = 2i+1 right = 2i+2
        //IF one based indexing take left = 2i right 2i+1
        //Intution behind this formula is the number of elements will be same on left and right  hence(2i)
        // on the right side one more is required including the left elemnent hence the plus 1
        int maxSize = Integer.MIN_VALUE;
        indexQ.offer(0);
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int start = 0;
            int end = 0;
            //Logic to avoid overflow keeping th eelemnt in size
            int min = indexQ.peek();
            for(int i =0;i<size;i++){
                TreeNode cur = queue.poll();
                int index = indexQ.poll()-min;
                if(i==0) start = index;
                if(i==size-1) end = index;
                if(cur.left !=null){
                    queue.add(cur.left);
                    indexQ.offer(2*index+1);
                }
                if(cur.right !=null){
                    queue.add(cur.right);
                    indexQ.offer(2*index+2);
                }
            }
            maxSize = Math.max(maxSize,end-start+1);
        }
        return maxSize;
    }
}
