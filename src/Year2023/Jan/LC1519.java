package Year2023.Jan;

import java.util.ArrayList;
import java.util.List;

public class LC1519 {

    public static void main(String[] args) {

    }

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] a:edges){
            adjList.get(a[0]).add(a[1]);
            adjList.get(a[1]).add(a[0]);
        }
        int[] res = new int[n];
        getCount(adjList,labels,0,-1,res);
        return res;
    }

    public int[] getCount(List<List<Integer>> adjList,String labels,int idx,int parent,int[] result){
        int[] charCount = new int[26];
        char symbol = labels.charAt(idx);
        charCount[symbol-'a']++;
        for(int t:adjList.get(idx)){
          if(t==parent) continue;
          int[] childCount = getCount(adjList,labels,t,idx,result);
          for(int i=0;i<26;i++){
              charCount[i] += childCount[i];
          }
        }
        result[idx] = charCount[symbol-'a'];
        return charCount;
    }
}
