package LeetCodeChallenge.APR2022;

import TopicWise2022.Tree.common.TreeNode;

import java.util.Stack;

/**
 * @author mmichaelbarboza
 * on 10:55 PM 4/20/2022
 * Time Taken:
 */
public class LC173BinarySearchTreeIterator {
    public static void main(String[] args) {

    }

    class BSTIterator {

        Stack<TreeNode> stack = null;
        TreeNode cur = null;

        public BSTIterator(TreeNode root) {
            cur = root;
            stack = new Stack<TreeNode>();
        }

        public int next() {
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode t = stack.pop();
            cur = t.right;
            return t.val;
        }

        public boolean hasNext() {
            return cur!=null || !stack.isEmpty();
        }
    }
}
