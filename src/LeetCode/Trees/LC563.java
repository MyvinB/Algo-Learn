package LeetCode.Trees;

public class LC563 {
    int tilt = 0;

    public int findTilt(TreeNode root) {
        postOrder(root);
        return tilt;
    }

    public int postOrder(TreeNode root) {
        if (root == null)
            return 0;
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        tilt += Math.abs(left - right);
        return left + right + root.val;
    }
}
