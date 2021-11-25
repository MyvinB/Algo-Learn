package practise;

import com.sun.source.tree.Tree;

/**
 * @author mmichaelbarboza
 * on 11:27 PM 11/25/2021
 */
public class LC617 {

    static TreeNode root1, root2;

    public static void main(String[] args) {
        root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);
        root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);
        mergeTrees(root1,root2);


    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode root = null;

        return dfs(root1,root2,null);
    }


    public static TreeNode dfs(TreeNode root1, TreeNode root2, TreeNode root){
        int sum = 0;
        if(root1 ==null && root2 == null) return null;
        if(root1!= null) sum+=root1.val;
        if(root2!=null) sum+=root2.val;
        root = new TreeNode(sum);
        root.left = dfs(root1!=null?root1.left:null,  root2!=null?root2.left:null,  root.left);
        root.right = dfs(root1!=null?root1.right:null,root2!=null?root2.right:null,root.right);
        return root;
    }
}
