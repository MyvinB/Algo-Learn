package LeetCodeChallenge.APR2022;

import TopicWise2022.Tree.common.TreeNode;

import java.util.Stack;

/**
 * @author mmichaelbarboza
 * on 10:33 AM 4/18/2022
 * Time Taken:
 */
public class LC230 {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root!=null){
            while(root!=null){
                stack.push(root.left);
                root = root.left;
            }
            root = stack.pop();
            if(k-- == 0) return root.val;
            root = root.right;
        }
        return -1;
     }
}
