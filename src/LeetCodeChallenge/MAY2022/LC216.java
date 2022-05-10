package LeetCodeChallenge.MAY2022;

import java.util.ArrayList;
import java.util.List;

public class LC216 {


    public static void main(String[] args) {
        System.out.println(combinationSum3(4,1));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res,k,n,new ArrayList<>(),1,0);
        return res;
    }


    public static void dfs(List<List<Integer>> res,int k, int n,List<Integer> cur,int start,int total){
        if(cur.size()==k && total!=n){
            return;
        }

        if(cur.size()==k && total ==n){
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i=start;i<=9;i++){
            cur.add(i);
            dfs(res,k,n,cur,i+1,total+i);
            cur.remove(cur.size()-1);
        }
    }
}
