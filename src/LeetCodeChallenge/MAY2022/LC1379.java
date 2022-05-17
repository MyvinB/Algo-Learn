package LeetCodeChallenge.MAY2022;

import TopicWise2022.Tree.common.TreeNode;

public class LC1379 {

    public static void main(String[] args) {

    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original==null) return null;
        if(original==target) return cloned;

        TreeNode left = getTargetCopy(original.left,cloned.left,target);
        if(left!=null){
            return left;
        }
        return getTargetCopy(original.right,cloned.right,target);
    }
}
