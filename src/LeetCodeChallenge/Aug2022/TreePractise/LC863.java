package LeetCodeChallenge.Aug2022.TreePractise;

import TopicWise2022.Tree.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC863 {

    public static void main(String[] args) {

    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        HashMap<TreeNode,TreeNode> map = new HashMap<>();
        HashSet<TreeNode> set = new HashSet<>();
        int dist = 0;
        List<Integer> res = new ArrayList<>();
        queue.add(root);
        //Building the map only for the parent node
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode cur = queue.poll();
                if(cur == target) break;
                if(cur.left!=null){
                    queue.add(cur.left);
                    map.put(cur.left,cur);
                }
                if(cur.right!=null){
                    queue.add(cur.right);
                    map.put(cur.right,cur);
                }
            }
        }
        queue.clear();
        queue.offer(target);
        //Cannot add the target node
        set.add(target);
        while(!queue.isEmpty()){
            if(dist==k){
                //Basically at this level we have all the nodes at distance k
                while(!queue.isEmpty()) res.add(queue.poll().val);
            }
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode cur = queue.poll();
                if(cur.left!=null && set.add(cur.left)) queue.add(cur.left);
                if(cur.right!=null && set.add(cur.right)) queue.add(cur.right);
                if(map.get(cur)!=null && set.add(map.get(cur))) queue.add(map.get(cur));
            }
            //With every level increase the distance as its one move
            dist++;
        }
        return res;
    }
}
