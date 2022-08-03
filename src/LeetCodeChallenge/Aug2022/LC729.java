package LeetCodeChallenge.Aug2022;

import java.util.HashMap;
import java.util.TreeMap;

public class LC729 {

    public static void main(String[] args) {

    }

    class MyCalendar {
        TreeMap<Integer,Integer> map;
        public MyCalendar() {
            map = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            if(map.floorEntry(start)!=null && start<map.floorEntry(start).getValue()){
                return false;
            }
            if(map.ceilingEntry(start)!=null && end > map.ceilingEntry(start).getKey()){
                return false;
            }
            map.put(start,end);
            return true;
        }
    }
}
