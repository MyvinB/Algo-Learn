package LeetCodeChallenge.July2022;

import java.util.Arrays;

public class LC473 {

    public static void main(String[] args) {
        int[] t = new int[]{3,3,3,3,4};
        System.out.println(makesquare(t));
    }

    public static boolean makesquare(int[] matchsticks) {
        int sum =0;
        for(int a:matchsticks) sum+=a;
        if(sum%4!=0) return false;
        int len = sum/4;
        int[] sides = new int[4];
        Arrays.sort(matchsticks);
        return dfs(matchsticks,matchsticks.length-1,sides,len);
    }

    public static boolean dfs(int[] matchsticks,int indx,int[] sides,int target){
        if(indx==-1) return true;
        for(int i=0;i<4;i++){
            if(matchsticks[indx]+sides[i]<=target){
                sides[i] += matchsticks[indx];
                if(dfs(matchsticks,indx-1,sides,target)) return true;
                sides[i] -= matchsticks[indx];
            }

        }
        return false;
    }
}
