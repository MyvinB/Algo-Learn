package LeetCodeChallenge.Aug2022.TreePractise;

import LeetCode.Array.ProductOfArrayExceptSelfLC238;
import TopicWise2022.Tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC145 {

    public static void main(String[] args) {

    }
    //Using two stack
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.add(root);

        while(!stack1.isEmpty()){
            root = stack1.pop();
            stack2.add(root);
            if(root.left!=null) stack1.add(root.left);
            if(root.right!=null) stack1.add(root.right);
        }

        while(!stack2.isEmpty()){
            res.add(stack2.pop().val);
        }
        return res;
    }


    public List<Integer> postOrderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = null;
        while(root!=null || !stack.isEmpty()){
            if(root!=null){
                stack.add(root);
                root = root.left;
            }else {
                temp = stack.peek().right;
                if(temp==null){
                    temp = stack.pop();
                    res.add(temp.val);
                    while(!stack.isEmpty() && temp==stack.peek().right){
                        temp = stack.peek();
                        res.add(stack.pop().val);
                    }
                }else root = temp;
            }

        }
        return res;

    }
}
