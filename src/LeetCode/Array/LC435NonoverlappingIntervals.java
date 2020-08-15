package LeetCode.Array;/*
 @author Myvin Barboza
 15/08/20 7:26 PM 
 */

import java.util.Arrays;

public class LC435NonoverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 100}, {11, 22}, {1,11}, {2, 101}};
        eraseOverlapIntervals(intervals);

    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0) return 0;
        /* Sorting the back values*/

        Arrays.sort(intervals,(arr1,arr2)->arr1[1]-arr2[1]);
        int res=0;
        int end=intervals[0][1];
        for(int[] interval:intervals){
            if(interval[0]<end){
                res++;
            }
            else
                end=interval[1];
        }


        return res-1;


        /*
         Arrays.sort(intervals,(arr1,arr2)->arr1[0]-arr2[0]);
        int previousEnd=intervals[0][0];
        int res=0;
        for(int[] interval:intervals){
            if(interval[0]>=previousEnd){
                previousEnd=interval[1];
            }
            else{
                res++;
                previousEnd = Math.min(previousEnd, interval[1]);
            }

        }
        return res;
        */
    }

}
