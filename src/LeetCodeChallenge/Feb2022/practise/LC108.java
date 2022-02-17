package LeetCodeChallenge.Feb2022.practise;

/**
 * @author mmichaelbarboza
 * on 10:15 AM 2/17/2022
 * Time Taken:
 */
public class LC108 {
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


        public static void main(String[] args) {

    }

    public TreeNode sortedArrayToBST(int[] nums) {
         return createTree(nums,0,nums.length-1);
    }

    public TreeNode createTree(int[] nums,int l,int h){
        if(h<l) return null;
        int mid = l+(h-l)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createTree(nums,l,mid-1);
        root.right = createTree(nums,mid+1,h);
        return root;
    }

    }
}
