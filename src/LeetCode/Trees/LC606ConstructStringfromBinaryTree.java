package LeetCode.Trees;/*
 @author Myvin Barboza
 27/07/20 10:05 AM 
 */

public class LC606ConstructStringfromBinaryTree {

    public static void main(String[] args) {

    }

    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        helper(t, sb);
        return sb.toString();
    }

    static void helper(TreeNode t, StringBuilder sb) {
        if (t != null) {
            sb.append(t.val);
            if (t.left != null || t.right != null) {
                sb.append("(");
                helper(t.left, sb);
                sb.append(")");

                if (t.right != null) {
                    sb.append("(");
                    helper(t.right, sb);
                    sb.append(")");
                }

            }
        }

    }
}