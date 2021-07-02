package LeetCodeChallenge.JUNE2021;

public class LC236 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        /*
        below can be replaced with this
                  return left == null ? right : right == null ? left : root;
        */
        if (left != null && right != null) return root;
        if (left == null && right == null) return null;
        return left != null ? left : right;
    }
}
