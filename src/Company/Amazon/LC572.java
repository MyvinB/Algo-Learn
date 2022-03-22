package Company.Amazon;

import TopicWise2022.Tree.common.TreeNode;

/**
 * @author mmichaelbarboza
 * on 8:45 AM 3/22/2022
 * Time Taken:
 */
public class LC572 {
    public static void main(String[] args) {

    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //if not root then try left and right;
        if(root == null) return false;
        if(isSame(root,subRoot)) return true;
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }

    public boolean isSame(TreeNode s, TreeNode t){
        if(s == null && t== null) return true;
        if(s==null || t==null) return false;
        if(s.val!=t.val) return false;
        return isSame(s.left ,t.left) && isSame(s.right,t.right);
    }
}
