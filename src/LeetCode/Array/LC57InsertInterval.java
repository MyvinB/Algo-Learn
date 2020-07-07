package LeetCode.Array;/*
 @author Myvin Barboza
 07/07/20 5:47 AM 
 */

import java.util.ArrayList;
import java.util.List;

public class LC57InsertInterval {


    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res=new ArrayList<>();
        for(int[] i:intervals){
            if(newInterval==null ||i[1]<newInterval[0]){
                res.add(i);
            }
            else if(newInterval[1]<i[0]){
                res.add(newInterval);
                newInterval=null;
                res.add(i);
            }else {
                newInterval[0]=Math.min(i[0],newInterval[0]);
                newInterval[1]=Math.max(i[1],newInterval[1]);

            }
        }
        if(newInterval!=null) res.add(newInterval);

        return res.toArray(new int[res.size()][]);


    }

}
