package LeetCodeChallenge.JUNE2022;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class LC2300 {

    public static void main(String[] args) {
        int[] p = new int[]{3,1,2};
        int[] f = new int[]{8,5,8};
        System.out.println(successfulPairs(p,f,16));
    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        TreeMap<Long,Integer> map = new TreeMap<>();
        map.put(Long.MAX_VALUE,potions.length);
        for(int i=potions.length;i>=0;i--){
            map.put((long)potions[i],i);
        }
        for(int i=0;i<spells.length;i++){
            long need =(spells[i]+success-1)/spells[i];
            spells[i] = potions.length-map.ceilingEntry(need).getValue();
        }
        return spells;
    }
}
