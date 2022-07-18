package LeetCodeChallenge.July2022;





import TopicWise2022.Tree.common.TreeNode;

import javax.xml.transform.Templates;
import java.util.HashMap;

public class LC105 {

    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int m = preorder.length;
        int n = inorder.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return buildTree(preorder,0,m-1,inorder,0,n-1,map);
    }

    public TreeNode buildTree(int[] preOrder,int preStart, int preEnd, int[] inOrder, int inStart, int inEnd, HashMap<Integer,Integer> map){
        if(preStart>preEnd || inStart>inEnd) return null;
        TreeNode node = new TreeNode(preOrder[preStart]);
        int inRoot = map.get(preOrder[preStart]);
        int numsLeft = inRoot-inStart;
        node.left = buildTree(preOrder,preStart+1,preEnd+numsLeft,inOrder,inStart,inRoot-1,map);
        node.right = buildTree(preOrder,preStart+numsLeft+1,preEnd,inOrder,inRoot+1,inEnd,map);
        return node;
    }
}
