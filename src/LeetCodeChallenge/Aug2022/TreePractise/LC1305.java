package LeetCodeChallenge.Aug2022.TreePractise;

import TopicWise2022.Tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC1305 {

    public static void main(String[] args) {

    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stack1= new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while(root1!=null || root2!=null || !stack1.isEmpty() || !stack2.isEmpty()){

            while(root1!=null){
                stack1.push(root1);
                root1 = root1.left;
            }
            while(root2!=null){
                stack2.push(root2);
                root2 = root2.left;
            }
            if(stack2.isEmpty() || !stack1.isEmpty() && stack1.peek().val<=stack2.peek().val){
                root1 = stack1.pop();
                res.add(root1.val);
                root1 = root1.right;
            }else{
                root2 = stack2.pop();
                res.add(root2.val);
                root2 = root2.right;
            }
        }
        return res;
    }
}
