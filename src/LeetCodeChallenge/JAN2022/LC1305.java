package LeetCodeChallenge.JAN2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author mmichaelbarboza
 * on 12:03 PM 1/26/2022
 */
public class LC1305 {


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
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(1);
        a.left = new TreeNode(1);
        a.right = new TreeNode(4);
        b.left = new TreeNode(0);
        b.right = new TreeNode(3);
        System.out.println(getAllElements(a,b));
    }

    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while(root1!=null || root2!=null || !st1.isEmpty() || !st2.isEmpty()){

            while(root1!=null){
                st1.push(root1);
                root1 = root1.left;
            }

            while(root2!=null){
                st2.push(root2);
                root2 = root2.left;
            }

            if(st2.isEmpty() || (!st1.isEmpty() && st1.peek().val<=st2.peek().val)) {
                root1 = st1.pop();
                res.add(root1.val);
                root1 = root1.right;
            }else {
                root2 = st2.pop();
                res.add(root2.val);
                root2 = root2.right;
            }

        }

        return res;
    }


}
