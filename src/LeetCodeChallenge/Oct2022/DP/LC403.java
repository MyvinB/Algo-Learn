package LeetCodeChallenge.Oct2022.DP;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LC403 {

    public static void main(String[] args) {
        int[] t = new int[]{0,1,3,5,6,8,12,17};
        System.out.println(canCross(t));
    }

    public static boolean canCross(int[] stones) {
        int n = stones.length;
        if(n==0) return true;
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
        map.put(0,new HashSet<>());
        map.get(0).add(1);

        for(int i=1;i<n;i++){
            map.put(stones[i],new HashSet<>());
        }
        for(int i=0;i<stones.length;i++){
            int pos = stones[i];
            for(int step:map.get(pos)){
                int reach = pos+step;
                if(reach==stones[n-1]) return true;
                Set<Integer> set = map.get(reach);
                if(set!=null){
                    set.add(step);
                    if(step-1>0) set.add(step-1);
                    set.add(step+1);
                }
            }
        }
        return false;
    }




}
