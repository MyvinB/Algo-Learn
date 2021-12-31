package LeetCodeChallenge.December2021;

/**
 * @author mmichaelbarboza
 * on 7:41 PM 12/31/2021
 */
public class LC1026 {
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
    private int maxDiff=0;
    public int maxAncestorDiff(TreeNode root) {
        if(root==null)
            return maxDiff;
        getMaxDiff(root);
        return maxDiff;
    }

    public int[] getMaxDiff(TreeNode root){
        if(root==null){
            return new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE};
        }
        int left[] = getMaxDiff(root.left);
        int right[] = getMaxDiff(root.right);
        int min = Math.min(root.val,Math.min(left[0],right[0]));
        int max = Math.max(root.val,Math.max(left[1],right[1]));
        maxDiff = Math.max(maxDiff,Math.max(root.val-min,max-root.val));
        return new int[]{min,max};
    }
}
