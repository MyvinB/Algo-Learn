package LeetCodeChallenge.Aug2022.TreePractise;

import TopicWise2022.Tree.common.TreeNode;

public class LC448 {

    public static void main(String[] args) {

    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        TreeNode successor = null;
        while(root!=null){
            if(p.val>=root.val){
                root = root.right;
            }else {
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }
}
