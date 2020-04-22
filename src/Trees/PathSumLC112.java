package Trees;

/*
 @author Myvin Barboza
 22/04/20 3:39 PM 
 */public class PathSumLC112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)return false;
        if(root.left == null && root.right == null && sum - root.val == 0) return true;

        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
    }


     public static void main(String[] args) {

    }
 }