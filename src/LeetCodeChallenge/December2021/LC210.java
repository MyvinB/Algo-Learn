package LeetCodeChallenge.December2021;

import java.util.*;

/**
 * @author mmichaelbarboza
 * on 11:45 PM 12/23/2021
 */
public class LC210 {

    public static void main(String[] args) {

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for(int i=0;i<numCourses;i++){
            map.put(i,new ArrayList<>());
        }
        int indegree[] = new int[numCourses];
        for(int temp[]:prerequisites){
            int dependentCourse = temp[1];
            int course = temp[0];
            indegree[course]++;
            map.get(dependentCourse).add(course);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        int[] result = new int[numCourses];
        int t=0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                int val = queue.poll();
                result[t++] = val;
                for(Integer child: map.get(val)){
                    indegree[child]--;
                    if(indegree[child]==0){
                        queue.add(child);
                    }
                }
            }
        }
        return t == numCourses?result:new int[]{};


    }
}
