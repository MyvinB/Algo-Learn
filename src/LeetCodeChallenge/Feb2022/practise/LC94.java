package LeetCodeChallenge.Feb2022.practise;

import java.util.*;

/**
 * @author mmichaelbarboza
 * on 10:59 AM 2/11/2022
 * Time Taken:
 */
public class LC94 {
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

    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while( cur!=null||!stack.isEmpty()){
            while(cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }


    public List<Integer> inorderTraversalDfs(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while( cur!=null||!stack.isEmpty()){
            while(cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }

    public void inOrder(TreeNode root,List<Integer> res){
       if(root==null) return;
       inOrder(root.left,res);
       res.add(root.val);
       inOrder(root.right,res);
    }
}
