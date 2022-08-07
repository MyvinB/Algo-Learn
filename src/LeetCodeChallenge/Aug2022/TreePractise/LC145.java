package LeetCodeChallenge.Aug2022.TreePractise;

import TopicWise2022.Tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC145 {

    public static void main(String[] args) {

    }

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
}
