package LeetCodeChallenge.Oct2022.Stack;

import TopicWise2022.Tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC144 {

    public static void main(String[] args) {

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if(root!=null)
            stack.add(root);
        List<Integer> res = new ArrayList<>();
        while(!stack.isEmpty()){
            root = stack.pop();
            res.add(root.val);
            if(root.right!=null){
                stack.add(root.right);
            }
            if(root.left!=null){
                stack.add(root.left);
            }

        }
        return res;

    }
}
