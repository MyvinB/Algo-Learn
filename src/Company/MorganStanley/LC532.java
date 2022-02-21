package Company.MorganStanley;

import java.util.HashMap;

/**
 * @author mmichaelbarboza
 * on 9:41 AM 2/21/2022
 * Time Taken:
 */
public class LC532 {

    public static void main(String[] args) {

    }

    public int findPairs(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int count=0;
        for(int t:map.keySet()){
            if(k>0 && map.containsKey(t+k)) count++;
            if(k==0 && map.get(t)>=2) count++;
        }
        return count;
    }
}
