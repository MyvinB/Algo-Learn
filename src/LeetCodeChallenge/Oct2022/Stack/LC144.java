package LeetCodeChallenge.Oct2022.Stack;

import TopicWise2022.Tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC144 {

    public static void main(String[] args) {

    }
    //Remeber in preorder we populate right in stack
    //in order we populate left in stack
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while(root!=null || !stack.isEmpty()){
            res.add(root.val);
            if(root.right!=null){
                stack.add(root.right);
            }
            root = root.left;
            if(root==null && !stack.isEmpty()) root= stack.pop();
        }
        return res;

    }
}
