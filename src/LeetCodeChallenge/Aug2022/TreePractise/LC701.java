package LeetCodeChallenge.Aug2022.TreePractise;

import TopicWise2022.Tree.common.TreeNode;
import com.sun.source.tree.YieldTree;

public class LC701 {

    public static void main(String[] args) {

    }

    //Recursively
    public TreeNode insertIntoBSTRR(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        if(root.val>val) root.left = insertIntoBST(root.left,val);
        else root.right = insertIntoBST(root.right,val);
        return root;
    }
    //Iteratively
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode head = root;
        if(root==null) return new TreeNode(val);
        while(true){
            if(root.val>val){
                if(root.left!=null) root = root.left;
                else {
                    root.left = new TreeNode(val);
                    break;
                }
            }else {
                if(root.right!=null) root = root.right;
                else {
                    root.right = new TreeNode(val);
                    break;
                }
            }
        }
        return head;
    }
}
