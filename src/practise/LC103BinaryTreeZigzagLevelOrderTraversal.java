package practise;/*
 @author Myvin Barboza
 22/07/20 12:38 PM 
 */

import java.util.ArrayList;
import java.util.List;

public class LC103BinaryTreeZigzagLevelOrderTraversal {

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        dfs(root,0,list);
        return list;
    }

    static void dfs(TreeNode root,int level,List<List<Integer>> list){
        //terminal
        if(root==null) return;

        if(list.size()==level){
            List<Integer> temp=new ArrayList<>();
            list.add(temp);
        }

        List<Integer> temp=list.get(level);
        if(level%2==0) temp.add(root.val);
        else temp.add(0,root.val);

        dfs(root.left,level+1,list);
        dfs(root.right,level+1,list);

    }


}
