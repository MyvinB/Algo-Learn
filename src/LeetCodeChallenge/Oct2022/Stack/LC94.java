package LeetCodeChallenge.Oct2022.Stack;

import TopicWise2022.Tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC94 {

    //Inorder traversal of binary tree
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root= stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
