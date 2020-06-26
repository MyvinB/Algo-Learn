package LeetCode.Trees;/*
 @author Myvin Barboza
 26/06/20 8:42 AM 
 */

import java.time.temporal.Temporal;

public class LC106ConstructBinaryTreeFromInorderAndPostOrderTraversal {

    static TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode n=helper(postorder.length-1,0,inorder.length-1,postorder,inorder);
        return n;
    }

    static TreeNode helper(int poEnd,int inStart,int inEnd,int postOrder[],int inOrder[]){
        if(inStart>inEnd || poEnd<0){
            return null;
        }
        TreeNode root=new TreeNode(postOrder[poEnd]);
        int index=0;
        for (int i = inStart; i <=inEnd ; i++) {
            if(postOrder[poEnd]==inOrder[i]){
                index=i;
                break;
            }
        }
        root.right=helper(poEnd-1,index+1,inEnd,postOrder,inOrder);
        root.left=helper(poEnd-(inEnd-index+1),inStart,index-1,postOrder,inOrder);
        return root;

    }


    public static void main(String[] args) {
        int inOrder[]={9,3,15,20,7};
        int postOrder[]={9,15,7,20,3};
        System.out.println(buildTree(inOrder,postOrder));
    }
}
