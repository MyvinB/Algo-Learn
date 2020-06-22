package LeetCode.Trees;/*
 @author Myvin Barboza
 22/06/20 10:34 AM 
 */

public class LC105ConstructBinaryTreefromPreorderAndInorderTraversal {

    static public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode t=helper(0,0,inorder.length-1,preorder,inorder);
        return t;

    }

    static TreeNode helper(int prestart, int inStart,int inEnd, int[] preOrder,int[] inOrder){
        //terminal conditions
        if(prestart> preOrder.length-1 || inStart>inEnd) return null;
        TreeNode root=new TreeNode(preOrder[prestart]);
        int inIndex=0;
        //find the index the inOrder element array
        for (int i = 0; i <=inEnd ; i++) {
            if(preOrder[prestart]==inOrder[i]){ inIndex=i; break;}
        }
        //the left to the element we need to find so inIndex-1 for the end
        root.left=helper(prestart+1,inStart,inIndex-1,preOrder,inOrder);
        //the right of the element so inIndex+1 start and end as it is
        //for the prestart here we need to ignore the left elements so we get the right
        //for that inIndex-inStart +1 as we are starting from zero
        // example we find 20 at inIndex=3 and inStart=2 get the diff =1+(start from zero)1 and add it
        //to current preStart value which is index 2 preOrder[2]=20 +2 to index gives us preOrder[2]=7
        root.right=helper(prestart+inIndex-inStart+1,inIndex+1,inEnd,preOrder,inOrder);



        return root;
    }


    public static void main(String[] args) {
        int pre[]={3,9,20,15,7};
        int in[]={9,3,15,20,7};
        System.out.println(buildTree(pre,in));


    }


}
