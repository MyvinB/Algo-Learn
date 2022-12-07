package LeetCodeChallenge.December2022;

import TopicWise2022.Tree.common.TreeNode;

public class LC938 {

    public static void main(String[] args) {

    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null) return 0;
        if(root.val>high) return rangeSumBST(root.left,low,high);
        if(root.val<low) return rangeSumBST(root.right,low,high);
        return root.val+ rangeSumBST(root.left,low,high)+rangeSumBST(root.right,low,high);
    }
}
