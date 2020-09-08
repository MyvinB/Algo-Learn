package LeetCode.BitWiseAlgo;



public class LC1022SumofRootToLeafBinaryNumbers {



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
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root,0);
    }

    int dfs(TreeNode root,int val){
        if(root==null) return 0;
        val=val<<1|root.val;
        if(root.left==root.right)
            return val;
        else
            return dfs(root.left,val)+dfs(root.right,val);

    }
}
