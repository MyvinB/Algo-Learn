package practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mmichaelbarboza
 * on 3:22 PM 11/24/2021
 */
public class LC56 {
    public static void main(String[] args) {
        int[][]  A= new int[][]{{1,4},{0,4}};
        int[][] res =merge(A);
        for(int[] r:res){
            System.out.println(Arrays.toString(r));
        }
    }


    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals,(i1,i2)->i1[0]-i2[0]);
        int[] newInterval = intervals[0];
        res.add(newInterval);
        for(int[] interval:intervals){
            if(interval[0]<=newInterval[1]){
                newInterval[1] = Math.max(interval[1],newInterval[1]);
            }
            else {
                 newInterval = interval;
                 res.add(newInterval);
            }
        }

        return res.toArray(new int[0][]);
    }
}
