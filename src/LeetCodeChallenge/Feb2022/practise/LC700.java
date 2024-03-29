package LeetCodeChallenge.Feb2022.practise;

/**
 * @author mmichaelbarboza
 * on 12:16 PM 2/14/2022
 * Time Taken: 2 min
 */
public class LC700 {

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

    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null) return null;
        if(root.val>val) return searchBST(root.left,val);
        if(root.val<val) return searchBST(root.right,val);
        return root;
    }
}
