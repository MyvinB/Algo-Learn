package LeetCodeChallenge.Aug2022.TreePractise;

import TopicWise2022.Tree.common.TreeNode;

public class LC1008 {

    public static void main(String[] args) {

    }

    public TreeNode bstFromPreorder(int[] preorder) {
            return constructBst(preorder,Integer.MAX_VALUE,new int[]{0});
    }

    public TreeNode constructBst(int[] preorder,int bound, int[] index){
        if(index[0] == preorder.length|| preorder[index[0]]>bound) return null;
        //We got an element increase the index;
        TreeNode root = new TreeNode(preorder[index[0]++]);
        //Now the bound will be with root value for the left element
        root.left = constructBst(preorder,root.val,index);
        // Here the root remain the same as the main parent elemnt
        root.right = constructBst(preorder,bound,index);
        return root;
    }
}
