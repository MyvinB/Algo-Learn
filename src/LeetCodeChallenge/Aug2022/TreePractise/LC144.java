package LeetCodeChallenge.Aug2022.TreePractise;

import TopicWise2022.Tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC144 {

    public static void main(String[] args) {

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            res.add(root.val);
            if(root.right!=null) stack.push(root.right);
            if(root.left!=null) stack.push(root.left);
        }
        return res;
    }
}
