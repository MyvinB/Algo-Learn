package LeetCode.Trees;
/*
 @author Myvin Barboza
 21/05/20 3:38 PM 
 */

public class LC104MaximumDepthofBinaryTree {
    int i=0;
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));

    }




    public static void main(String[] args) {

    }
}