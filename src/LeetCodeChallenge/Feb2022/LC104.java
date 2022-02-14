package LeetCodeChallenge.Feb2022;

/**
 * @author mmichaelbarboza
 * on 8:58 AM 2/14/2022
 * Time Taken:
 */
public class LC104 {
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

    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return Math.max(1+maxDepth(root.left),1+maxDepth(root.right));
    }

}
