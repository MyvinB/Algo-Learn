package LeetCodeChallenge.Oct2022.Tree;

import TopicWise2022.Tree.common.TreeNode;

import java.util.HashMap;

public class LC105 {

    public static void main(String[] args) {

    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length-1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<=n;i++){
            map.put(inorder[i],i);
        }
        return buildTree(preorder,0,n,inorder,0,n,map);
    }

    public TreeNode buildTree(int[] preOrder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd,HashMap<Integer,Integer> map){
        //Base conditions
        if(preStart>preEnd || inStart>inEnd) return null;
        //first get the root
        TreeNode root = new TreeNode(preOrder[preStart]);
        int inRoot = map.get(root.val);
        //Use inOrder to get the nums tothe left
        int numsLeft = inRoot-inStart;
        //preStart+1 -> exclude the root element
        //preStart+numsleft will give us the end
        // inRoot-1 will give us the left half have a visual memory of all of this
        root.left = buildTree(preOrder,preStart+1,preStart+numsLeft,inorder,inStart,inRoot-1,map);
        //preStart+numsLeft+1 will give us the start of the right half excluding left elements
        //inRoot+1 will give us right half again visualise code
        root.right = buildTree(preOrder,preStart+numsLeft+1,preEnd,inorder,inRoot+1,inEnd,map);
        return root;
    }

}
