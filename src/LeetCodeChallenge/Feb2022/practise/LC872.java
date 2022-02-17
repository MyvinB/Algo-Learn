package LeetCodeChallenge.Feb2022.practise;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author mmichaelbarboza
 * on 10:26 AM 2/17/2022
 * Time Taken:
 */
public class LC872 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

        public static void main(String[] args) {

    }
    public boolean leafSimilarNaive(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        dfs(root1,res);
        dfs(root2,res);
        int i=0;
        int size = res.size();
        int k=size/2;

        while(k<size){
            if(res.get(i++)!=res.get(k++)) return false;
        }
        return true;
    }

    public void dfs(TreeNode root, List<Integer> res){
        if(root==null) return;
        if(root.left == null && root.right==null){
            res.add(root.val);
            return;
        }
        dfs(root.left, res);
        dfs(root.right,res);
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

    public int dfs(Stack<TreeNode> s) {
        while(true){
            TreeNode node = s.pop();
            if(node.right!=null) s.push(node.right);
            if(node.left!=null) s.push(node.left);
            if(node.left==null && node.right==null) return node.val;
        }
    }

}
