package practise;

import Challenge.A;

import java.util.ArrayList;
import java.util.List;

public class LC57InsertInterval {
    public static void main(String[] args) {

    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res=new ArrayList<>();
        for(int ar[]:intervals){
           if(newInterval==null || ar[1]<newInterval[0]){
               res.add(ar);
           }
           else if(newInterval[1]<ar[0]){
               res.add(newInterval);
               newInterval=null;
               res.add(ar);
           }
           else {
               newInterval[0]=Math.min(ar[0],newInterval[0]);
               newInterval[1]=Math.max(ar[1],newInterval[1]);
           }

        }

        if(newInterval!=null)res.add(newInterval);
        return res.toArray(new int[res.size()][]);
}
}
