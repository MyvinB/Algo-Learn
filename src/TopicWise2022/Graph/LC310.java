package TopicWise2022.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author mmichaelbarboza
 * on 4:51 AM 3/26/2022
 * Time Taken:
 */
public class LC310 {

    public static void main(String[] args) {

    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if(n<=0) return res;
        if(n==1){
            res.add(0);
            return res;
        }
        int[] degree = new int[n];
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            degree[a]++;
            degree[b]++;
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i =0;i<n;i++){
            if(degree[i]==1){
                queue.add(i);
            }
        }

        while(n>2){
            int size = queue.size();
            n -= size;
            while(size-->0){
                int node = queue.poll();
                degree[node]--;
                List<Integer> temp = adjList.get(node);
                for(int i=0;i<temp.size();i++){
                    int childNode = temp.get(i);
                    degree[childNode]--;
                    if(degree[childNode]==1) queue.add(childNode);
                }
            }
        }

        res.addAll(queue);
        return res;
    }
}
