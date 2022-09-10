package LeetCodeChallenge.Sep2022.GP;

import java.util.Arrays;

public class LC435 {

    public static void main(String[] args) {
        int[][] t = new int[][]{{1,2},{2,3},{3,4},{1,3}};
        System.out.println(eraseOverlapIntervals(t));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(arr1, arr2)->arr1[0]-arr2[0]);
        //taking a false prev end to avoid the first element
        int prevEnd = intervals[0][0];
        int res = 0;
        for(int[] i:intervals){
            if(i[0]>=prevEnd){
                prevEnd = i[1];
            }else{
                res++;
                prevEnd = Math.min(prevEnd,i[1]);
            }
        }
        return res;
    }
}
