package LeetCodeChallenge.July2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC56 {

    public static void main(String[] args) {

    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> res = new ArrayList<>();
        int[] newInterval = intervals[0];
        res.add(newInterval);
        for(int[] interval:intervals){
            if(interval[0]<=newInterval[1]){
                newInterval[1] = Math.max(newInterval[1],interval[1]);
            }else{
                newInterval = interval;
                res.add(newInterval);
            }
        }
        return res.toArray(new int[0][]);
    }
}
