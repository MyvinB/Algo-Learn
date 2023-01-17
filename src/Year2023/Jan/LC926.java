package Year2023.Jan;

import java.util.Arrays;

public class LC926 {

    public static void main(String[] args) {
//        System.out.println(minFlipsMonoIncr("00110"));
    }
    //011010
    public static int minFlipsMonoIncr(String s) {
        int countFlip =0;
        int flipOne = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1') flipOne++;
            else {
                countFlip = Math.min(countFlip+1,flipOne);

            }
        }
        return countFlip;
    }

//Memory error with  dp two dimensional array

//    public static int minFlipsMonoIncr(String s) {
//        int n = s.length();
//
//        while(s.charAt(i)=='0')i++;
//        int[][] dp = new int[s.length()][s.length()];
//        for(int[] d:dp){
//            Arrays.fill(d,-1);
//        }
//        return recurMemo(s,0,i,dp);
//    }
//    public static int recurMemo(String s,int prev,int idx,int[][] dp){
//        if(idx==s.length()) return 0;
//        if(dp[idx][prev]!=-1) return dp[idx][prev];
//        int flip = Integer.MAX_VALUE;
//        int noFlip = Integer.MAX_VALUE;
//        //to flip
//        if(s.charAt(idx)=='0'){
//            if(prev==1){
//                flip = 1+ recurMemo(s,1,idx+1,dp);
//            }else {
//                flip = 1+ recurMemo(s,1,idx+1,dp);
//                noFlip = recurMemo(s,0,idx+1,dp);
//            }
//        }else if(s.charAt(idx)=='1'){
//            if(prev==0){
//                flip = 1+ recurMemo(s,0,idx+1,dp);
//                noFlip = recurMemo(s,1,idx+1,dp);
//            }else noFlip = recurMemo(s,1,idx+1,dp);
//        }
//        return dp[idx][prev] = Math.min(flip,noFlip);
//    }
}
