package Year2024.Daily;

public class LC129 {

    public static void main(String[] args) {

    }

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

    public int sumNumbers(TreeNode root) {
        return recur(root,0);
    }


    public int recur(TreeNode root,int pathSum){
        if(root==null) return 0;
        pathSum = pathSum *10 + root.val;

        if(root.left==null && root.right ==null){
            return pathSum;
        }
        return recur(root.left,pathSum) + recur(root.right,pathSum);
    }
}
