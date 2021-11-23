package practise;

import com.sun.source.tree.Tree;

import java.util.*;

/**
 * @author mmichaelbarboza
 * on 7:50 PM 11/23/2021
 */
public class LC987 {
    static TreeNode root;
    public static void main(String[] args) {
        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        LC987 lc = new LC987();
        System.out.println(lc.verticalTraversal(root));
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    HashMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new HashMap<>();
    int min=0,max=0;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfsHelper(root,0,0);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=min;i<=max;i++){
            System.out.println(i);
            List<Integer> vlevel = new ArrayList<>();
            //List will be ordered here treemap magic
            for(int key:map.get(i).keySet()){
                while(!map.get(i).get(key).isEmpty()){
                    //asscending priority by default
                    vlevel.add(map.get(i).get(key).poll());
                }
            }
            res.add(vlevel);
        }
        return res;
    }

    void dfsHelper(TreeNode root,int vlevel,int hlevel){
        if(root!=null){
            min = Math.min(min,vlevel);
            max = Math.max(max,vlevel);
            if(map.get(vlevel) == null){
                map.put(vlevel,new TreeMap<>());
            }
            if(map.get(vlevel).get(hlevel) == null){
                map.get(vlevel).put(hlevel,new PriorityQueue<>());
            }
            map.get(vlevel).get(hlevel).add(root.val);
            dfsHelper(root.left,vlevel-1,hlevel+1);
            dfsHelper(root.right,vlevel+1,hlevel+1);
        }
    }


}
