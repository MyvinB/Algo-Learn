package LeetCodeChallenge.APR2022;

import TopicWise2022.Tree.common.TreeNode;

/**
 * @author mmichaelbarboza
 * on 3:22 PM 4/17/2022
 * Time Taken:
 */
public class LC897 {

    public static void main(String[] args) {

    }
    TreeNode head=null;
    TreeNode prev=null;
    public TreeNode increasingBST(TreeNode root) {
        if(root==null) return null;
        increasingBST(root.left);
        if(prev!=null){
            root.left = null;
            prev.right = root;
        }
        //it would be set only one time ie left most element
        if(head==null) head = root;
        prev = root;
        increasingBST(root.right);
        return head;
    }
}
