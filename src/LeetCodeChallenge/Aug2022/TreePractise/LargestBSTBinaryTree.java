package LeetCodeChallenge.Aug2022.TreePractise;

import TopicWise2022.Tree.common.TreeNode;
import TopicWise2022.Tree.common.TreePrinter;

public class LargestBSTBinaryTree {

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(10);
//
//        root.left = new TreeNode(15);
//        root.right = new TreeNode(8);
//
//        root.left.left = new TreeNode(12);
//        root.left.right = new TreeNode(20);
//
//        root.right.left = new TreeNode(5);
//        root.right.right = new TreeNode(2);


        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(15);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(12);
        root.left.right = new TreeNode(20);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(9);

        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(14);
        root.right.left.left = new TreeNode(4);
        root.right.left.right = new TreeNode(7);

        root.right.right.right = new TreeNode(10);

        TreePrinter.print(root);
        System.out.println(largestBSTSubtree(root));
    }
//    0 maxNode
//    1 minNode
//    2 size
    private static int[] largestBSTSubtreeHelper(TreeNode root) {
        if(root==null) return new int[]{Integer.MIN_VALUE,Integer.MAX_VALUE,0};
        int[] left = largestBSTSubtreeHelper(root.left);
        int[] right = largestBSTSubtreeHelper(root.right);

        if(left[0]<root.val && root.val<right[1]){
            return new int[]{Math.min(left[1],root.val),Math.max(root.val,right[0]),1+left[2]+right[2]};
        }
        return new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE,Math.max(left[2],right[2])};
    }


    public static int largestBSTSubtree(TreeNode root) {
        return largestBSTSubtreeHelper(root)[2];
    }


}
