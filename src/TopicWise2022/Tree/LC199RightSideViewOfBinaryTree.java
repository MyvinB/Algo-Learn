package TopicWise2022.Tree;

import TopicWise2022.Tree.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author mmichaelbarboza
 * on 10:28 AM 3/7/2022
 * Time Taken:
 */
public class LC199RightSideViewOfBinaryTree {



    public static void main(String[] args) {

    }

    public List<Integer> rightSideViewIterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode cur = queue.poll();
                if(cur.left!=null) queue.add(cur.left);
                if(cur.right!=null) queue.add(cur.right);
                if(i==size) res.add(cur.val);
            }
        }
        return res;
    }

    public List<Integer> rightSideViewRecursive(TreeNode root){
        List<Integer> res = new ArrayList<>();
        rightSideView(root,res,0);
        return res;
    }

    public void rightSideView(TreeNode root, List<Integer> res, int curDepth){
        if(root==null) return;
        if(curDepth == res.size()){
            res.add(root.val);
        }
        //If you want to print left just make left come first
        rightSideView(root.right,res,curDepth+1);
        rightSideView(root.left,res,curDepth+1);
    }
}
