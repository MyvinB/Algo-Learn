package LeetCodeChallenge.Feb2022.practise;

/**
 * @author mmichaelbarboza
 * on 9:45 AM 2/14/2022
 * Time Taken:
 */
public class LC617 {

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

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null) return null;
        int val = 0;
        if(root1!=null) val += root1.val;
        if(root2!=null) val += root2.val;
        TreeNode res = new TreeNode(val);
        res.left = mergeTrees(root1!=null?root1.left:null,root2!=null?root2.left:null);
        res.right = mergeTrees(root1!=null?root1.right:null,root2!=null?root2.right:null);
        return res;
    }


}
