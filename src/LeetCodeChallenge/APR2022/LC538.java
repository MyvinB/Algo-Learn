package LeetCodeChallenge.APR2022;

import TopicWise2022.Tree.common.TreeNode;

/**
 * @author mmichaelbarboza
 * on 2:05 PM 4/16/2022
 * Time Taken:
 */
public class LC538 {

    public static void main(String[] args) {

    }

    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;


    }
}
