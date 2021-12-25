package LeetCodeChallenge.December2021;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mmichaelbarboza
 * on 7:31 PM 12/25/2021
 */
public class LC56MergeIntervals {
    public static void main(String[] args) {

    }

    public int[][] merge(int[][] intervals) {
        if(intervals.length==1) return intervals;

        List<int[]> res = new ArrayList<>();
        int[] newInterval = intervals[0];
        res.add(newInterval);
        for(int[] interval:intervals){
            if(interval[0]<=newInterval[1]){
                newInterval[1] = Math.max(interval[1],newInterval[1]);
            }
            else {
                res.add(newInterval);
            }
        }
        return res.toArray(new int[0][]);
    }
}
