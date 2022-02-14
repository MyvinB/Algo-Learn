package LeetCodeChallenge.Feb2022.practise;

/**
 * @author mmichaelbarboza
 * on 10:04 AM 2/14/2022
 * Time Taken: 25 min
 */
public class LC897 {

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
    TreeNode cur;
    public TreeNode increasingBST1(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        cur = ans;
        dfsInorder(root);
        return ans.right;
    }
    //Global pinter increment and ppointer shift
    void dfsInorder(TreeNode root){
        if(root==null) return;
        dfsInorder(root.left);
        root.left = null;
        cur.right = root;
        cur = cur.right;
        dfsInorder(root.right);
    }

    TreeNode prev=null,head=null;
    public TreeNode increasingBST(TreeNode root) {
        if(root==null) return null;
        increasingBST(root.left);
        if(prev!=null){
            root.left = null;
            prev.right = root;
        }
        if(head==null) head = root;
        prev = root;
        increasingBST(root.right);
        return head;
    }


}
