package LeetCodeChallenge.Aug2022.TreePractise;

import TopicWise2022.Tree.common.TreeNode;

public class LC222 {

    public static void main(String[] args) {

    }

    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int left = countLeftHeight(root);
        int right = countRightHeight(root);
        if(left==right) return (2<<(left))-1;
        else return countNodes(root.left) +countNodes(root.right)+1;
    }

    public int countLeftHeight(TreeNode root){
        int count = 0;
        while(root.left!=null){
            count++;
            root = root.left;
        }
        return count;
    }
    public int countRightHeight(TreeNode root){
        int count = 0;
        while(root.right!=null){
            count++;
            root = root.right;

        }
        return count;
    }
}
