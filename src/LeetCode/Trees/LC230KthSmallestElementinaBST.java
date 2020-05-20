package LeetCode.Trees;
/*
 @author Myvin Barboza
 20/05/20 3:25 PM 
 */

public class LC230KthSmallestElementinaBST {
    int i=0;
    int val;
    public int kthSmallest(TreeNode root, int k) {
        kth(root,k);
        return val;
    }

    public void kth(TreeNode root,int k){
        if(root!=null){
            kth(root.left,k);
            i++;
            if(i==k) {
                val=root.val;
                return;
            }
            kth(root.right,k);
        }
    }




    public static void main(String[] args) {

    }
}