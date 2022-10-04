package LeetCodeChallenge.Oct2022.Daily;

import java.nio.charset.StandardCharsets;

public class LC1578 {

    public static void main(String[] args) {
      String t =   "bbbaaa";
      int[]p = new int[]{4,9,3,8,8,9};
        System.out.println(minCost(t,p));
    }

    public static int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int start = 0,end = 0;
        int cost = 0;
        while(start<n && end<n){
            int maxTime = 0;
            int groupTotal = 0;
            while(end<n && colors.charAt(start)==colors.charAt(end)){
                maxTime = Math.max(maxTime,neededTime[end]);
                groupTotal += neededTime[end];
                end++;
            }
            cost += groupTotal -maxTime;
            start =end;
        }
        return cost;
    }


}
