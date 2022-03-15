package Company.Amazon;

import TopicWise2022.Tree.common.TreeNode;

import java.util.*;

/**
 * @author mmichaelbarboza
 * on 10:02 AM 3/15/2022
 * Time Taken:
 */
public class LC863 {
    public static void main(String[] args) {

    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> set = new HashSet<>();
        //Building the map only for the parent node
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur == target) break;
            if(cur.left!=null){
                map.put(cur.left,cur);
                queue.add(cur.left);
            }
            if(cur.right !=null){
                map.put(cur.right,cur);
                queue.add(cur.right);
            }
        }
        queue.clear();
        queue.add(target);
        set.add(target);
        int dist = 0;
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){

            if(dist == k){
                //Basically at this level we have all the nodes at distance k
                while(!queue.isEmpty()) res.add(queue.poll().val);
            }
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode cur = queue.poll();
                if(cur.left !=null && set.add(cur.left)) queue.add(cur.left);
                if(cur.right !=null && set.add(cur.right)) queue.add(cur.right);
                if(map.get(cur)!=null && set.add(map.get(cur))) queue.add(map.get(cur));
            }
            //With every level increase the distance as its one move
            dist++;
        }






    }
}
