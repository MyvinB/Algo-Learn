package Year2023.Jan;

import java.util.ArrayList;
import java.util.List;

public class LC2246 {

    public static void main(String[] args) {
        int[] t = new int[]{-1,0,1};
//        System.out.println(longestPath(t,"aab"));
    }
    int result = 0;
    public int longestPath(int[] parent, String s) {
        List<List<Integer>> adjList = new ArrayList<>();
        int n = parent.length;
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=1;i<parent.length;i++){
            int u = i;
            int v = parent[i];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        dfs(adjList,s,0,-1);
        return result;
    }

    public int dfs(List<List<Integer>> adjList, String s,int idx,int parent) {
        int largest = 0;
        int secondLargest = 0;

        for(int t:adjList.get(idx)){
            if(t==parent ) continue;
            int childLongestLength = dfs(adjList,s,t,idx);
            if(s.charAt(t)==s.charAt(idx))continue;
            if(childLongestLength>=largest){
                secondLargest = largest;
                largest = childLongestLength;
            }else if(childLongestLength>=secondLargest){
                secondLargest = childLongestLength;
            }
        }
        int oneIsGood = Math.max(largest,secondLargest) + 1; // still exploring since we took one path
        int bothIsGood = largest+secondLargest+1; // if we consider left and right that mean thats our path is done we cannto take top answer
        int onlyRootIsGood = 1;// only root into consideration
        int tempMax = Math.max(oneIsGood,bothIsGood);
        tempMax = Math.max(tempMax,onlyRootIsGood);
        result = Math.max(result,tempMax);
        return Math.max(onlyRootIsGood,oneIsGood);//cannot take both is good
    }
}
