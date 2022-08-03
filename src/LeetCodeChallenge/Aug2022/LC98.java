package LeetCodeChallenge.Aug2022;

import TopicWise2022.Tree.common.TreeNode;

import java.util.Stack;

public class LC98 {

    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null|| !stack.isEmpty()){
            //Keep adding th esmaller values to the stack ie the left values eventually right do come but it's like from a left perspective
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            //we found a case wherer left <root <right the statement is wrong //even consider equal case
            if(pre!=null && root.val<=pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
}
