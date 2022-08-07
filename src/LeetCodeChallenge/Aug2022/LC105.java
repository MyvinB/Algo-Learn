package LeetCodeChallenge.Aug2022;

import TopicWise2022.Tree.common.TreeNode;

import java.util.HashMap;

public class LC105 {

    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int m = preorder.length-1;
        int n = inorder.length-1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<=n;i++){
            map.put(inorder[i],i);
        }
        return buildTree(preorder,0,m,inorder,0,n,map);

    }

    public TreeNode buildTree(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd,HashMap<Integer,Integer> map){
        //Termianl conditions invalid case
        if(preStart>preEnd || inStart>inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = map.get(root.val);
        int numsLeft = inRoot-inStart;
        //preStart+1 -> +1 we do not need the root element so +1
        //preStart+numsLeft -> end would be the numOfelement in the left plus it's zero index
        //inRoot-1 -> we do not need the root elment in the root
        root.left = buildTree(preorder,preStart+1,preStart+numsLeft,inorder,inStart,inRoot-1,map);
        //preStart+numsLeft+1 -> now we need to start from the right so numOfelemnts on the left +1 to get the right element
        //inRoot+1 -> We do not need the root element
        root.right = buildTree(preorder,preStart+numsLeft+1,preEnd,inorder,inRoot+1,inEnd,map);
        return root;
    }
}
