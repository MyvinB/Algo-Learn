package LeetCode.Graph;/*
 @author Myvin Barboza
 18/07/20 4:20 PM 
 */

import java.util.*;

public class LC210CourseScheduleII {
    static HashMap<Integer, List<Integer>> adjList = new HashMap<>();
    static int inDegree[];
    public static void addEdge(int src, int dest){
        adjList.putIfAbsent(src, new ArrayList<>());
        List<Integer> list = adjList.get(src);
        list.add(dest);
        adjList.put(src,list);
        //incrementing our indegree
        inDegree[dest]++;

    }

    static int[] findOrder(int numCourses, int[][] prerequisites) {
        inDegree=new int[numCourses];
        int ans[]=new int[numCourses];
      //graph creation
        for(int a[]:prerequisites){
        addEdge(a[1],a[0]);
      }
        //
        Queue<Integer> queue=new LinkedList<>();
        //the one with no indegree will be are start nodes
        for(int i=0;i<numCourses;i++) if(inDegree[i]==0) queue.offer(i);
        int t=0;

        while(!queue.isEmpty()){
            int s=queue.poll();
            ans[t++]=s;
            List<Integer> list=adjList.get(s);
            if(list!=null){
              for(int e:list){
                  //decrement the indegree if used
                  inDegree[e]--;
                  //if it is zero add it to the queue so it can be processed
                  if(inDegree[e]==0) queue.add(e);
              }
            }

        }
        //this is just a boolean check for LC207
        return t==numCourses? ans:new int[0];


    }

    public static void main(String[] args) {
    //[[1,0],[2,0],[3,1],[3,2]]
        int a[][]={{0,1}};
        System.out.println(Arrays.toString(findOrder(2,a)));
    }
/*
///BULL SHIT DFS CODE DOESN't work for cyclic
    public static void addEdge(int src, int dest){
        adjList.putIfAbsent(src, new ArrayList<>());
        List<Integer> list = adjList.get(src);
        list.add(dest);
        adjList.put(src,list);
    }
    static int[] findOrder(int numCourses, int[][] prerequisites) {
        Stack<Integer> stack=new Stack<>();
        int order[]=new int[numCourses];
        int visited[]=new int[numCourses];
        for(int a[]:prerequisites){
            addEdge(a[1],a[0]);
        }
       for(int i=0;i<numCourses;i++){
           if(visited[i]==0)
           dfs(stack,visited,i);
       }
      //  System.out.println(stack);

       int i=0;
       while(!stack.isEmpty()){
           order[i]=stack.pop();
           i++;
       }
       return order;
    }

    static void dfs(Stack<Integer> stack,int visited[],int i){
        if(visited[i]==1) return;
        visited[i]=1;
        List<Integer> list=adjList.get(i);
        if(list!=null){
            for(int e:list){
                dfs(stack,visited,e);

            }
        }

        stack.push(i);

    }
*/



}
