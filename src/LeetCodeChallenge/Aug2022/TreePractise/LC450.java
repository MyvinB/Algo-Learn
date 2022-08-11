package LeetCodeChallenge.Aug2022.TreePractise;

import TopicWise2022.Tree.common.TreeNode;

public class LC450 {

    public static void main(String[] args) {

    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val>key) root.left = deleteNode(root.left,key);
        else if(root.val<key) root.right =  deleteNode(root.right,key);
        else {
            if(root.left==null) return root.right;
            if(root.right==null) return root.left;
            TreeNode rightToRoot = root.right;
            TreeNode lastRight = findRightMost(root.left);
            lastRight.right = rightToRoot;
            return root.left;
        }
        return root;
    }

    public TreeNode findRightMost(TreeNode root){
        while(root.right!= null){
            root = root.right;
        }
        return root;
    }
}
