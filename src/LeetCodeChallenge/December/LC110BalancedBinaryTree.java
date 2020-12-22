package LeetCodeChallenge.December;/*
 @author Myvin Barboza
 22/12/20 7:30 PM 
 */

public class LC110BalancedBinaryTree {
    private boolean isbalanced  = true;
    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return isbalanced;

    }
    public int maxDepth(TreeNode root){
        if( root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        if(Math.abs(left-right)>1){
            isbalanced = false;
        }

        return Math.max(left,right)+1;
    }
}
