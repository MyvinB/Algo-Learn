package LeetCodeChallenge.Sep2022.DpPractise;

import TopicWise2022.Tree.common.TreeNode;

public class LC814 {

    public static void main(String[] args) {

    }

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) return null;
        return root;
    }
}
