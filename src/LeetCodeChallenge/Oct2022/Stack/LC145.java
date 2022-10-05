package LeetCodeChallenge.Oct2022.Stack;

import TopicWise2022.Tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC145 {

    public static void main(String[] args) {

    }

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if(root!=null) stack.push(root);
        List<Integer> res = new ArrayList<>();
        while(!stack.isEmpty()){
            root = stack.pop();
            res.add(0,root.val);
            if(root.left!=null){
                stack.push(root.left);
            }
            if(root.right!=null){
                stack.push(root.right);
            }
        }
        return res;
    }
}
