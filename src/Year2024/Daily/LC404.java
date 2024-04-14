package Year2024.Daily;

public class LC404 {

//     * Definition for a binary tree node.
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


    public int sumOfLeftLeaves(TreeNode root) {
        return recur(root,0);
    }

    public int recur(TreeNode root,int flag){
        int sum = 0;
        if(root.left==null && root.right==null && flag==1){
            return root.val;
        }
        if(root.left!=null){
            sum +=recur(root.left,1);
        }
        if(root.right!=null){
            sum +=recur(root.right,0);
        }

        if(sum!=0) return sum;
        return 0;
    }
}
