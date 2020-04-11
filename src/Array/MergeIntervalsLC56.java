package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 @author Myvin Barboza
 11/04/20 9:33 AM 
 */public class MergeIntervalsLC56 {
//[[1,3],[2,6],[8,10],[15,18]]
    static int[][] merge(int[][] intervals) {
        if(intervals.length<=1) return intervals;
        Arrays.sort(intervals,(arr1,arr2)->(Integer.compare(arr1[0],arr2[0])));
        List<int[]> list =new ArrayList<>();
        int[] current_interval=intervals[0];
        list.add(current_interval);
        for(int[] interval:intervals){

            int current_end=current_interval[1];
            int next_begin=interval[0];
            int next_end=interval[1];
            if(current_end>=next_begin){
                current_interval[1]=Math.max(current_end,next_end);
            }
            else {
                current_interval=interval;
                list.add(current_interval);
            }

        }


        return list.toArray(new int[list.size()][]);
    }


     public static void main(String[] args) {
        int merge[][]={{1,4},{0,4}};
        merge= new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
         System.out.println(Arrays.deepToString( merge(merge)));
         //System.out.println(Arrays.deepToString(merge));
    }
}