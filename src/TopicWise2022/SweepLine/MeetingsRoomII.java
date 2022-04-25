package TopicWise2022.SweepLine;

import java.util.Arrays;
import java.util.List;

/**
 * @author mmichaelbarboza
 * on 6:16 AM 4/25/2022
 * Time Taken:
 */
public class MeetingsRoomII {
    public class Interval {
      int start, end;
      Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
    }


    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i=0;i<intervals.size();i++){
            Interval temp = intervals.get(i);
            start[i] = temp.start;
            end[i] = temp.end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int s=0,e=0,count=0,res=0;
        while(s<n){
            if(start[s]<end[e]){
                s++;
                count++;
            }
            //If meeting start time and end time is same we first end the meeting hence end<=start is the condition here
            else{
                e++;
                count--;
            }
            res = Math.max(res,count);

        }
        return res;
    }
}
