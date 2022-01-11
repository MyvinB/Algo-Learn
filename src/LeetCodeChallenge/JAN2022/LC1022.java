package LeetCodeChallenge.JAN2022;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mmichaelbarboza
 * on 8:59 AM 1/11/2022
 */
public class LC1022 {

     public static class TreeNode {
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
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(0);
        a.right = new TreeNode(1);
        a.left.left = new TreeNode(0);
        a.left.right = new TreeNode(1);
        a.right.left = new TreeNode(0);
        a.right.right = new TreeNode(1);

        TreeNode b = new TreeNode(1);
        b.left = new TreeNode(1);
        System.out.println(sumRootToLeaf(b));
    }

    public static int sumRootToLeaf(TreeNode root) {
        return dfs(root,new ArrayList<>());
    }
    //Naive approach 0(n2)
    public static int dfs(TreeNode root, List<Integer> temp){
         if(root.left == null && root.right == null){
             StringBuilder sb = new StringBuilder();
             for(int i=0;i<temp.size();i++){
                 sb.append(temp.get(i));
             }
             sb.append(root.val);
             return Integer.parseInt(sb.toString(),2);
         }
         temp.add(root.val);
         int left = root.left!=null? dfs(root.left,temp):0;
         int right = root.right!=null?dfs(root.right,temp):0;
         temp.remove(temp.size()-1);
         return left + right ;
    }

    public int dfsOptimised(TreeNode root, int val){
         if(root==null) return 0;
         val = val*2+root.val;
         return root.left==root.right?val:dfsOptimised(root.left,val)+dfsOptimised(root.right,val);
    }
}
