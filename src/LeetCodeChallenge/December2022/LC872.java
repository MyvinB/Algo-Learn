package LeetCodeChallenge.December2022;

import TopicWise2022.Tree.common.TreeNode;

import java.util.Stack;

public class LC872 {

    public static void main(String[] args) {

    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root1);
        s2.push(root2);
        while(!s1.isEmpty() && !s2.isEmpty()){
            if(dfs(s1)!=dfs(s2)) return false;
        }
        return s1.isEmpty() && s2.isEmpty();
    }

    public int dfs(Stack<TreeNode> s1){
        while(true){
            TreeNode node = s1.pop();
            if(node.right!=null) s1.push(node.right);
            if(node.left!=null) s1.push(node.left);
            //we found leaf node
            if(node.left==null && node.right==null) return node.val;
        }
    }
}
