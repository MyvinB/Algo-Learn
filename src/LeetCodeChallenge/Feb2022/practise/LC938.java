package LeetCodeChallenge.Feb2022.practise;

/**
 * @author mmichaelbarboza
 * on 9:05 AM 2/14/2022
 * Time Taken:
 */
public class LC938 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static void main(String[] args) {

    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        //Terminal condition
        if(root==null) return 0;
        if(root.val>high){
            return rangeSumBST(root.left,low,high);
        }
        if(root.val<low){
             return rangeSumBST(root.right,low,high);
        }
        //Looking for those values that are in range of low and high
        return root.val +rangeSumBST(root.left,low,high) +rangeSumBST(root.right,low,high);
    }
}
