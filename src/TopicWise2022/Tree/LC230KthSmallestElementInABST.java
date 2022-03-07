package TopicWise2022.Tree;

import TopicWise2022.Tree.common.TreeNode;

import java.util.Stack;

/**
 * @author mmichaelbarboza
 * on 11:53 AM 3/7/2022
 * Time Taken:
 */
public class LC230KthSmallestElementInABST {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while((root!=null || !stack.isEmpty())){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(--k == 0) break;
            root = root.right;
        }
        return root.val;
    }
}
