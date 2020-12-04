package LeetCodeChallenge.December;/*
 @author Myvin Barboza
 04/12/20 12:17 PM 
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class LC897 {

    TreeNode cur;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        cur=ans;
        inorder(root);
        return ans.right;
    }

    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        root.left=null;
        cur.right =root;
        cur=cur.right;
        inorder(root.right);
    }
}
