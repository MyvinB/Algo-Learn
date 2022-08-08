package TopicWise2022.Tree.common;



/**
 * @author mmichaelbarboza
 * on 10:48 AM 3/7/2022
 * Time Taken:
 */

public class TreeNode implements TreePrinter.PrintableNode {
     public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left,TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public TreePrinter.PrintableNode getLeft() {
        return left;
    }

    @Override
    public TreePrinter.PrintableNode getRight() {
        return right;
    }

    @Override
    public String getText() {
        return String.valueOf(val);
    }
}

