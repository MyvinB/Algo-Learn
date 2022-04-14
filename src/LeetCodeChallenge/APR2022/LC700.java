package LeetCodeChallenge.APR2022;

import TopicWise2022.Tree.common.TreeNode;

/**
 * @author mmichaelbarboza
 * on 7:34 AM 4/14/2022
 * Time Taken:
 */
public class LC700 {

    public static void main(String[] args) {

    }

    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null) return null;
        if(val>root.val) return searchBST(root.right,val);
        else if(val<root.val) return searchBST(root.left,val);
        return root;
    }
}
