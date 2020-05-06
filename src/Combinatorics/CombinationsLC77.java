package Combinatorics;

import java.util.ArrayList;
import java.util.List;

/*
 @author Myvin Barboza
 30/04/20 9:50 AM 
 */public class CombinationsLC77 {





    static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list=new ArrayList<>();
        // handling edge conditions to make it faster but will work without it
            if(n==0 || k==0 || k>n ) return list;
          combine(list,new ArrayList<>(),n,k,1);
       // dfs(list,new ArrayList<>(),k,1,n-k+1);
        return list;

    }




    static void combine(List<List<Integer>> list,List<Integer> path, int n, int k,int start){

        if(k==0){
            list.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <=n ; i++) {
            path.add(i);
            combine(list,path,n,k-1,i);
            path.remove(path.size()-1);
        }
    }




     public static void main(String[] args) {

         long startTime = System.nanoTime();
         System.out.println(combine(2,2));
         long endTime   = System.nanoTime();
         long totalTime = endTime - startTime;
         System.out.println(totalTime);


    }


}