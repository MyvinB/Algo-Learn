package TopicWise2022.Tree;

import TopicWise2022.Tree.common.TreeNode;

import java.util.Stack;

/**
 * @author mmichaelbarboza
 * on 10:47 AM 3/7/2022
 * Time Taken:
 */
public class LC98ValidateBinaryTree {

    public static void main(String[] args) {

    }

    public boolean isValidBSTRecursive(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root,long min,long max) {
        if(root==null) return true;
        if(root.val<min || root.val>max) return false;
        return isValidBST(root.left,min,root.val) && isValidBST(root.right,root.val,max);
    }

    public boolean isValidBstIterative(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while(root!=null || !stack.isEmpty() ){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre!=null && root.val<=pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
}
