package LeetCodeChallenge.APR2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author mmichaelbarboza
 * on 10:54 AM 4/24/2022
 * Time Taken:
 */
public class LC1396 {

    public static void main(String[] args) {

    }



    class UndergroundSystem {
        //In the interview please use appropriate getters and setters to do stufff so they do not judge
        class Travel{
            String startStation;
            String endStation;
            int startTime;
            int endTime;
        }

        HashMap<String, List<Integer>> avg;
        HashMap<Integer,Travel> map;
        public UndergroundSystem() {
            avg = new HashMap<>();
            map = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            Travel travel = new Travel();
            travel.startStation = stationName;
            travel.startTime = t;
            map.put(id,travel);
        }

        public void checkOut(int id, String stationName, int t) {
            Travel travel = map.get(id);
            travel.endTime = t;
            travel.endStation = stationName;
            String destination = travel.startStation +"-"+ travel.endStation;
            int totalTime = travel.endTime - travel.startTime;
            if(avg.get(destination)==null){
                avg.put(destination,new ArrayList<>());
            }
            List<Integer> temp = avg.get(destination);
            temp.add(totalTime);
            avg.put(destination,temp);
        }

        public double getAverageTime(String startStation, String endStation) {
            String key = startStation +"-"+ endStation;
            List<Integer> res = avg.get(key);
            if(res==null) return 0;
            double sum = 0;
            for(int i=0;i<res.size();i++){
                sum+= res.get(i);
            }
            return sum/res.size();
        }


    }
}
