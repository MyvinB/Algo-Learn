package TopicWise2022.Graph;

import java.util.*;

/**
 * @author mmichaelbarboza
 * on 4:46 PM 3/25/2022
 * Time Taken:
 */
public class LC207 {

    public static void main(String[] args) {
        int n = 3;
        int[][] t = new int[][]{{0,2},{1,2},{2,0}};
        System.out.println(canFinishDFS(n,t));
    }


    public static boolean canFinishDFS(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for(int p[]:prerequisites){
            addToList(p[1],p[0],adjList);
        }
        int[] visited = new int[n];
        for(int i=0;i<n;i++){
            if(!dfs(i,visited,adjList)) return false;
        }
        return true;
    }
///--------------------------------------------------------------------------------------------BFS--------------------------------------------------------------------------------------------
    public static boolean canFinishBFS(int numCourses,int[][] prerequisites){
        int n = numCourses;
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        int[] inDegree = new int[n];
        for(int p[]:prerequisites){
            addToListBfs(p[1],p[0],adjList,inDegree);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++) if(inDegree[i]==0) queue.add(i);
        int level = 0;
        while(!queue.isEmpty()){
            level++;
            int node = queue.poll();
            if(adjList.containsKey(node)){
                List<Integer> temp = adjList.get(node);
                for(int i=0;i<temp.size();i++){
                    int childNode = temp.get(i);
                    inDegree[childNode]--;
                    if(inDegree[childNode]==0) queue.add(childNode);
                }
            }

        }
        return level == n;

    }

    public static void addToListBfs(int src,int dest,HashMap<Integer,List<Integer>> map,int[] inDegree) {
        if (!map.containsKey(src)) map.put(src, new ArrayList<>());
        List<Integer> temp = map.get(src);
        temp.add(dest);
        map.put(src, temp);
        inDegree[dest]++;
    }

///--------------------------------------------------------------------------------------------DFS--------------------------------------------------------------------------------------------

    public static boolean dfs(int index,int[] visited,HashMap<Integer,List<Integer>> adjList){
        //We found a cycle abord
        if(visited[index] == 1)  return false;
        // we have already processed and there was no cycle before so why bother
        if(visited[index] == 2) return true;
        visited[index] = 1;
        //adj list for this node does not have any prereq so we return true;
        if(adjList.containsKey(index)){
            List<Integer> destList = adjList.get(index);
            for(int i=0;i<destList.size();i++){
                int node = destList.get(i);
                if(!dfs(node,visited,adjList)) return false;
            }
        }

        visited[index] = 2;
        return true;
    }

    public static void addToList(int src,int dest,HashMap<Integer,List<Integer>> map) {
        if (!map.containsKey(src)) map.put(src, new ArrayList<>());
        List<Integer> temp = map.get(src);
        temp.add(dest);
        map.put(src, temp);
    }



}
