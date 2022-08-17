package LeetCodeChallenge.Aug2022.DpPractise;

import java.util.Arrays;

public class NinjaTraining {

    public static void main(String[] args) {

    }

    public static int ninjaTraining(int n, int points[][]) {
//        return recur(points,points.length-1,3);
//        int[][] dp = new int[n][4];
//        for (int[] row: dp)
//            Arrays.fill(row, -1);
//        return recurMemo(points,points.length-1,3,dp);
        return tabulation(points,n);
    }

    public static int recur(int[][] points,int day,int last){
        if(day==0){
            int maxi = 0;
            for(int task=0;task<3;task++){
                if(task!=last){
                    maxi = Math.max(maxi,points[0][task]);
                }
            }
            return maxi;
        }
        int maxi = 0;
        for(int task=0;task<3;task++){
            if(task!=last){
                int point = points[day][task] + recur(points,day-1,task);
                maxi = Math.max(maxi,point);
            }
        }
        return maxi;
    }

    public static int recurMemo(int[][] points,int day,int last,int[][] dp){
        if(dp[day][last]!=-1) return dp[day][last];
        if(day==0){
            int maxi = 0;
            for(int task=0;task<3;task++){
                if(task!=last){
                    maxi = Math.max(maxi,points[0][task]);
                }
            }
            return  dp[day][last]= maxi;
        }

        int maxi = 0;
        for(int task=0;task<3;task++){
            if(task!=last){
                int point = points[day][task] + recurMemo(points,day-1,task,dp);
                maxi = Math.max(maxi,point);
            }
        }
        return dp[day][last]= maxi;
    }
    /*If recurrence is top dowwn then tabulation will be bottom up
    * */
    public static int tabulation(int[][] points,int n){
        int[][] dp = new int[n][4];
        //Calculating base casese
        dp[0][0] = Math.max(points[0][1],points[0][2]);
        dp[0][1] = Math.max(points[0][0],points[0][2]);
        dp[0][2] = Math.max(points[0][0],points[0][1]);
        dp[0][3] = Math.max(points[0][0],Math.max(points[0][1],points[0][2]));
        for(int day=1;day<n;day++){
            for(int last= 0;last<4;last++){
                for(int task = 0;task<3;task++){
                    if(task!=last){
                        int point = points[day][task] + dp[day-1][task];
                        dp[day][last] = Math.max(dp[day][last],point);
                    }
                }
            }
        }
        return dp[n-1][3];
    }


}
