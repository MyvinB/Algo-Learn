package LeetCode.Trees;/*
 @author Myvin Barboza
 05/08/20 2:30 PM 
 */

import java.util.Arrays;
import java.util.Stack;

public class LC297SerializeandDeserializeBinaryTree {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        //2 4 5 3 1
        public void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("null,");
                return;
            }
            serialize(root.left, sb);
            serialize(root.right, sb);
            sb.append(root.val).append(",");
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            System.out.println(data);
            if (data.isEmpty()) return null;
            Stack<String> stack = new Stack<>();
            stack.addAll(Arrays.asList(data.split(",")));


            return deserialize(stack);
        }

        public TreeNode deserialize(Stack<String> stack) {
            if (stack.isEmpty()) return null;
            String value = stack.pop();
            if (value.equals("null"))
                return null;

            int val = Integer.parseInt(value);

            TreeNode root = new TreeNode(val);
            root.right = deserialize(stack);
            root.left = deserialize(stack);
            return root;

        }

    }
}


