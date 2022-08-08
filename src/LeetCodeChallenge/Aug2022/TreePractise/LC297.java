package LeetCodeChallenge.Aug2022.TreePractise;

import TopicWise2022.Tree.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC297 {

    public static void main(String[] args) {

    }

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root==null) return "";
            Queue<TreeNode> queue = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            queue.add(root);
            while(!queue.isEmpty()){
                TreeNode cur = queue.poll();
                if(cur==null){
                    sb.append("NULL"+",");
                    continue;
                }
                sb.append(cur.val+",");
                queue.add(cur.left);
                queue.add(cur.right);
            }
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data.isEmpty()) return null;
            String[] values = data.split(",");
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.valueOf(values[0]));
            queue.add(root);
            for(int i=1;i< values.length;i++){
                TreeNode cur = queue.poll();
                if(!values[i].equals("NULL")){
                    cur.left = new TreeNode(Integer.parseInt(values[i]));
                    queue.add(cur.left);
                }
                if(!values[++i].equals("NULL")){
                    cur.right = new TreeNode(Integer.parseInt(values[i]));
                    queue.add(cur.right);
                }
            }
            return root;
        }
    }
}
