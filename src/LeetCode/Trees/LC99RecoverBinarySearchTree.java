package LeetCode.Trees;
/*
Helpp Tushar Roy
Use of Morris Traversal to have O(1) space for tree traversal
link : https://www.youtube.com/watch?v=wGXB9OWhPTg

Conclusion for the pre first second
pre is the before node and its value if greater than the current node gives us first and temp second probably
the second node will change depending if there is a val smaller than the previous node
values of first and second are then exchanged
 */
public class LC99RecoverBinarySearchTree {
    public static void main(String[] args) {

    }

    public void recoverTree(TreeNode root) {
        TreeNode pre = null;
        TreeNode first = null;
        TreeNode second = null;
        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {
                if (pre != null && pre.val > current.val) {
                    if (first == null) {
                        first = pre;
                    }
                    second = current;
                }
                pre = current;
                current = current.right;

            } else {
                TreeNode predecessor = current.left;

                while (predecessor.right != current && predecessor.right != null)
                    predecessor = predecessor.right;
                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } else {
                    predecessor.right = null;

                    if (pre != null && pre.val > current.val) {
                        if (first == null) {
                            first = pre;
                        }
                        second = current;
                    }
                    pre = current;
                    current = current.right;

                }
            }
        }
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }

    }


}
