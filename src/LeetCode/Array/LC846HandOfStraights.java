package LeetCode.Array;
/*
 @author Myvin Barboza
 02/06/20 4:05 PM 
 */

import java.util.Map;
import java.util.TreeMap;

public class LC846HandOfStraights {

    public boolean isNStraightHand(int[] hand, int W) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int a:hand)map.put(a,1+map.getOrDefault(a,0));
        while(!map.isEmpty()){
            int minVal=map.firstKey();
            for(int i=minVal;i<minVal+W;i++){
                if(!map.containsKey(i)) return false;
                int count=map.get(i);
                if(count==1)map.remove(i);
                else map.replace(i,count-1);
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}