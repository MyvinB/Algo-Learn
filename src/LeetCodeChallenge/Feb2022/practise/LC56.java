package LeetCodeChallenge.Feb2022.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mmichaelbarboza
 * on 6:58 PM 2/20/2022
 * Time Taken:
 */
public class LC56 {

    public static void main(String[] args) {

    }

    public int[][] merge(int[][] intervals) {
        if(intervals.length <=1) return intervals;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int[] newInterval = intervals[0];
        List<int[]> res = new ArrayList<>();
        res.add(newInterval);
        for(int[] interval:intervals){
            if(interval[0]<=newInterval[1]){
                newInterval[1] = Math.max(newInterval[1],interval[1]);
            }else {
                newInterval = interval;
                res.add(newInterval);
            }
        }

        return res.toArray(new int[0][]);
    }
}
