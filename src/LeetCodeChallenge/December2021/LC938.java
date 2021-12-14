package LeetCodeChallenge.December2021;

/**
 * @author mmichaelbarboza
 * on 11:30 PM 12/14/2021
 */
public class LC938 {


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
         public int rangeSumBST(TreeNode root, int low, int high) {
          if(root == null) return 0;
          if(root.val<low) return rangeSumBST(root.right,low,high);
          if(root.val>high)  return rangeSumBST(root.left,low,high);
          return root.val + rangeSumBST(root.left,low,high) + rangeSumBST(root.right,low,high);
        }

}
