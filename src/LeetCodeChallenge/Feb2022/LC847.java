package LeetCodeChallenge.Feb2022;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mmichaelbarboza
 * on 9:19 AM 2/27/2022
 * Time Taken:
 */
public class LC847 {

    public static void main(String[] args) {

    }

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        if(n==1) return 0;
        int finalState = (1<<n) - 1;
        Queue<int[]> queue = new LinkedList<>();

        //Adding all the nodes initially cause we can start from anywhere
        //Adding the start bit mask position
        for(int i=0;i<graph.length;i++){
            queue.add(new int[]{i,1<<i});
        }

        int[][] visitedMap = new int[n][finalState+1];
        int shortestPath = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            shortestPath++;
            for(int i=0;i<size;i++){
                int[] head = queue.poll();
                System.out.println(Arrays.toString(head));
                int nodeId = head[0];
                int visitedNodeBitState = head[1];
                System.out.println(Integer.toBinaryString(visitedNodeBitState));
                for(int neighbour: graph[nodeId]){
                    int newVisitedNodeBitState = visitedNodeBitState | (1<<neighbour);
                    if(visitedMap[neighbour][newVisitedNodeBitState] == 1) continue;
                    if(newVisitedNodeBitState == finalState) return shortestPath;
                    visitedMap[neighbour][newVisitedNodeBitState] =1;
                    queue.add(new int[]{neighbour,newVisitedNodeBitState});
                }
            }
        }
        return  -1;
    }
}
