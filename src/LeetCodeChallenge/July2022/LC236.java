package LeetCodeChallenge.July2022;

import TopicWise2022.Tree.common.TreeNode;

public class LC236 {

    public static void main(String[] args) {

    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //if we find the element just return it terminal operations
        if(root==null || root==p || root == q){
            return root;
        }
        //Minify the tree by bringing up the root elements to the top and check if both left and right are not null
        //if not needed element the null value will bubble up from the leaf nodes
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left!=null && right!=null) return root;
        //for the case where only one is null then pass the non null value to minify
        return left!=null?left:right;
    }
}
