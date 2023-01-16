package Year2023.Jan;

import java.util.ArrayList;
import java.util.List;

public class LC57 {

    public static void main(String[] args) {

    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i =0,start = newInterval[0],end = newInterval[1];
        //All before the interval
        while(i<intervals.length && intervals[i][1]<newInterval[0]) res.add(intervals[i++]);
        //All during the interval
        while(i<intervals.length && intervals[i][0]<=newInterval[1]){
            start = Math.min(start,intervals[i][0]);
            end = Math.max(end,intervals[i][1]);
            i++;
        }
        res.add(new int[]{start,end});
        while(i<intervals.length) res.add(intervals[i++]);

        return res.toArray(new int[res.size()][]);

    }
}
