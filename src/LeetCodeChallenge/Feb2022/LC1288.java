package LeetCodeChallenge.Feb2022;

import java.util.Arrays;

/**
 * @author mmichaelbarboza
 * on 7:07 PM 2/20/2022
 * Time Taken:
 */
public class LC1288 {

    public static void main(String[] args) {
        System.out.println(removeCoveredIntervalsOpti(new int[][]{{1,4},{3,6},{2,8}}));
    }

    public static int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        int removalCount =0;
        int prevRange = -1;
        for(int interval[]: intervals){
            if(prevRange>=interval[1]){
                removalCount++;
            }else {
                prevRange = Math.max(prevRange,interval[1]);
            }
        }
        return intervals.length - removalCount;
    }

    public static int removeCoveredIntervalsOpti(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int left =-1,right=-1;
        int res = 0;
        for(int[] interval:intervals){
            if(interval[0]>left && interval[1]>right){
                left=interval[0];
                right =interval[1];
                res++;
            }
        }
        return res;
    }
}
