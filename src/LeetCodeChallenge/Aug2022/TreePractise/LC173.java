package LeetCodeChallenge.Aug2022.TreePractise;

import TopicWise2022.Tree.common.TreeNode;

import java.util.Stack;

public class LC173 {

    public static void main(String[] args) {

    }

    class BSTIterator {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = null;
        public BSTIterator(TreeNode root) {
             cur = root;
        }

        public int next() {
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode t= stack.pop();
            cur = t.right;
            return t.val;
        }

        public boolean hasNext() {
            return cur!=null || !stack.isEmpty();
        }
    }
}
