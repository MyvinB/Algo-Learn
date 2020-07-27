package practise;/*
 @author Myvin Barboza
 27/07/20 3:55 PM 
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class LC106BinaryTreefromInorderandPostorderTraversal {



    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode n=helper(postorder.length-1,0,inorder.length-1,inorder,postorder);
        return n;
    }
    static TreeNode helper(int post,int inStart,int inEnd,int[] inorder,int[] postorder){
        if(inStart>inEnd || post<0){
            return null;
        }
        int idx=0;
        for(int i=inStart;i<=inEnd;i++){
            if(postorder[post]==inorder[i]) {
                idx=i;
                break;
            }
        }
        TreeNode root=new TreeNode(postorder[post]);
        root.right=helper(post-1,idx+1,inEnd,inorder,postorder);
        //need to elimate the elements on the right side so a simple count will give it to us
        // us 1 is for the element at the index not to be included
        root.left=helper(post-(inEnd-idx+1),inStart,idx-1,inorder,postorder);
        return root;
    }

}
