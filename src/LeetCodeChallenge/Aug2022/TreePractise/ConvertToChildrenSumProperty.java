package LeetCodeChallenge.Aug2022.TreePractise;

import TopicWise2022.Tree.common.TreeNode;
import TopicWise2022.Tree.common.TreePrinter;

public class ConvertToChildrenSumProperty {

    public static void main(String[] args) {
        TreeNode  root = new TreeNode(2);
        root . left = new TreeNode(35);
        root . left . left = new TreeNode(2);
        root . left . right = new TreeNode(3);
        root . right = new TreeNode(10);
        root . right . left = new TreeNode(5);
        root . right . right = new TreeNode(2);
        TreePrinter.print(root);

        reorder(root);
        TreePrinter.print(root);
    }

    static void reorder(TreeNode root){
        if(root==null) return;
        int child = 0;
        if(root.left!=null) child+=root.left.val;
        if(root.right!=null) child+=root.right.val;
        if(child<root.val){
            if(root.left!=null) root.left.val = root.val;
            if(root.right!=null) root.right.val = root.val;
        }
        reorder(root.left);
        reorder(root.right);
        int total = 0;
        if(root.left!=null)total+=root.left.val;
        if(root.right!=null) total+=root.right.val;
        if(root.right!=null || root.left!=null) root.val = total;
    }
}
