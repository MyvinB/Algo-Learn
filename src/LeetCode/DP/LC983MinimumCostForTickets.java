package LeetCode.DP;

import java.util.Arrays;

public class LC983MinimumCostForTickets {
    public static void main(String[] args) {
    int days[]={1,4,6,7,8,20};
    int cost[]={2,7,15};
        System.out.println(mincostTickets(days,cost));
    }
    //dp bottom down approach
    static int minCostTicketsIterative(int[] days, int[] costs) {

        int lastDay=days[days.length-1];
        int[] dp=new int[lastDay+1];
        boolean[] isDay=new boolean[lastDay+1];

        for(int day:days)isDay[day]=true;

        for(int i=1;i<=lastDay;i++){
            if(!isDay[i]){

                dp[i]=dp[i-1];
                continue;
            }

            dp[i]=costs[0]+dp[i-1];
            dp[i]=Math.min(costs[1]+dp[Math.max(i-7,0)],dp[i]);
            dp[i]=Math.min(costs[2]+dp[Math.max(i-30,0)],dp[i]);

        }

        return dp[lastDay];

    }


    //Recursive
    //DP top down approach
/*
2D 7W 15M
4D 9W 15M
6D 9W 15M
8D 9W 15M
10D 9W 15M
11D 11W 15M

1,4,6,7,8,20
11   9  8  6   4    2
2
7
15
min=2

2+2=4
7+2=9
15(remains the same as accounts for 30 days)
min=4

2+4
//to reach 20 it will take 2$ more as 7+7=14 which includes 18 in the index
2+7=9
15
min=6

2+6=8
7+2=9
15
min=8

2+8=10
7+2=9
15
min=9

2+9=11
7+4=11
15
min=11

* */
    static int mincostTickets(int[] days, int[] costs) {


        int[] memo = new int[days.length];
        mincostTickets(0,days, costs, memo);
        System.out.println(Arrays.toString(memo));
        return 4;
    }

    private static int mincostTickets(int daysIndex,int[]days,int costs[],int memo[]) {
        if(daysIndex==days.length) return 0;

        if(memo[daysIndex]!=0){
            return memo[daysIndex];
        }

        int totalCostDay=costs[0]+mincostTickets(getNextDay(daysIndex,days,1),days,costs,memo);
        System.out.print(totalCostDay +"D ");

        int totalCostWeek=costs[1]+mincostTickets(getNextDay(daysIndex,days,7),days,costs,memo);
        System.out.print(totalCostWeek+"W ");
        int totalCostMonth=costs[2]+mincostTickets(getNextDay(daysIndex,days,30),days,costs,memo);
        System.out.print(totalCostMonth+"M ");
        memo[daysIndex]=Math.min(totalCostDay,Math.min(totalCostMonth,totalCostWeek));
        System.out.println("");
        return memo[daysIndex];

    }

    private static int getNextDay(int index,int days[],int duration){
        //-1 for zero base index
        int end=days[index]+duration-1;
        int newDayIndex=index;
        //1 4 6 7 will exit at 7
        while(newDayIndex<days.length && days[newDayIndex]<=end ){
            newDayIndex++;
        }
        return newDayIndex;
    }

}
