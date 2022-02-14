package LeetCodeChallenge.Feb2022.practise;

/**
 * @author mmichaelbarboza
 * on 4:11 PM 2/14/2022
 * Time Taken:
 */
public class LC266 {

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

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode n = new TreeNode(root.val);
        n.left = invertTree(root.right);
        n.right = invertTree(root.left);
        return n;
    }
}
