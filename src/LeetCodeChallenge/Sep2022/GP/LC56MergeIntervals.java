package LeetCodeChallenge.Sep2022.GP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC56MergeIntervals {

    public static void main(String[] args) {

    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int[] newInterval = intervals[0];
        List<int[]> res = new ArrayList<>();
        res.add(newInterval);
        for(int[] i:intervals){
            //Found overlapping case
            if(i[0]<=newInterval[1]){
                newInterval[1] = Math.max(newInterval[1],i[1]);
            }else{
                newInterval = i;
                res.add(newInterval);
            }
        }
        return res.toArray(new int[0][]);
    }
}
