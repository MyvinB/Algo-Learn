package LeetCodeChallenge.Aug2022.TreePractise;

import TopicWise2022.Tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC545 {

    public static void main(String[] args) {

    }

    public boolean isLeaf(TreeNode root){
        return root.left==null && root.right==null;
    }

    public void addLeafNode(TreeNode root,List<Integer> res){
        if(isLeaf(root)){
            res.add(root.val);
        }
        if(root.left!=null) addLeafNode(root.left,res);
        if(root.right!=null) addLeafNode(root.right,res);
    }

    public void addLeftBoundary(TreeNode root,List<Integer> res){
        TreeNode cur  = root.left;
        while(cur!=null){
            if(isLeaf(cur)==false) res.add(cur.val);
            if(cur.left!=null) cur = cur.left;
            else cur = cur.right;
        }
    }

    public void addRightBoundary(TreeNode root,List<Integer> res){
        TreeNode cur = root.right;
        List<Integer> temp = new ArrayList<>();
        while(cur!=null){
            if(isLeaf(cur)==false) temp.add(cur.val);
            if(cur.right!=null) cur = cur.right;
            else cur = cur.left;
        }
        for(int i=temp.size()-1;i>=0;i--) res.add(temp.get(i));
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(isLeaf(root)==false) res.add(root.val);
        addLeftBoundary(root,res);
        addLeafNode(root,res);
        addRightBoundary(root,res);
        return res;
    }
}
