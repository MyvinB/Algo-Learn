package LeetCodeChallenge.Oct2022.Tree;

import TopicWise2022.Tree.common.TreeNode;

import java.util.HashMap;

public class LC106 {

    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length-1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<=n;i++) map.put(inorder[i],i);
        return buildTree(postorder,0,n,inorder,0,n,map);
    }

    public TreeNode buildTree(int[] postOrder,int postStart,int postEnd,int[] inOrder,int inStart,int inEnd,HashMap<Integer,Integer> map){
        //Base case
        if(postStart>postEnd || inStart>inEnd) return null;
        TreeNode root = new TreeNode(postOrder[postEnd]);
        int inRoot = map.get(root.val);
        int numsLeft = inRoot-inStart;
        //postEnd is postStart+numsLeft
        root.left = buildTree(postOrder,postStart ,postStart+numsLeft-1,inOrder,inStart,inRoot-1,map);
        //since we do not consider the right element postEnd is minus one
        //and postStart we have already considered the left elements
        root.right = buildTree(postOrder,postStart+numsLeft,postEnd-1,inOrder,inRoot+1,inEnd,map);
        return root;
    }
}
