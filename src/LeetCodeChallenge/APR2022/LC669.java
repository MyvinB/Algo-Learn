package LeetCodeChallenge.APR2022;

import TopicWise2022.Tree.common.TreeNode;

/**
 * @author mmichaelbarboza
 * on 6:00 AM 4/15/2022
 * Time Taken:
 */
public class LC669 {

    public static void main(String[] args) {

    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null) return null;

        if(root.val<low) return trimBST(root.right,low,high);
        if(root.val>high) return trimBST(root.left,low,high);
        root.left = trimBST(root.left,low,high);
        root.right = trimBST(root.right,low,high);
        return root;
    }
}
