package LeetCodeChallenge.Aug2022.TreePractise;

import TopicWise2022.Tree.common.TreeNode;

import java.util.HashMap;

public class LC106 {

    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<inorder.length;i++) map.put(inorder[i],i);
        return buildTree(0,inorder.length-1,inorder,postorder.length-1,postorder,map);

    }

    public TreeNode buildTree(int inStart,int inEnd,int[] inOrder,int post,int[] postOrder,HashMap<Integer,Integer> map){
        if(inStart>inEnd) return null;
        TreeNode root = new TreeNode(postOrder[post]);
        int idx = map.get(root.val);
        root.left = buildTree(inStart,idx-1,inOrder,post-(inEnd-idx+1),postOrder,map);
        root.right = buildTree(idx+1,inEnd,inOrder,post-1,postOrder,map);
        return root;
    }
}
