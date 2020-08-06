package LeetCode.Trees;/*
 @author Myvin Barboza
 06/08/20 3:38 PM 
 */

public class LC236LowestCommonAncestorofaBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p|| root==q)return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);

        // if(left!=null && right!=null) return root;
        // if(left==null && right==null) return null;
        // return left==null?right:left;

        return left == null ? right : right == null ? left : root;

    }
}
