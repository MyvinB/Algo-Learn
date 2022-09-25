package Contest.LeetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Contest25September {

    public static void main(String[] args) {
        String[] names = new String[]{"Alice","Bob","Bob"};
        int[]heights = new int[]{155,185,150};
        System.out.println(Arrays.toString(sortPeople(names,heights)));

    }

    public static String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer,String> map = new HashMap<>();
        for(int i=0;i<names.length;i++) map.put(i,names[i]);
        HashMap<Integer,Integer> mapI = new HashMap<>();
        for(int i=0;i<heights.length;i++) mapI.put(heights[i],i);
        Arrays.sort(heights);
        int k = 0;
        for(int i=heights.length-1;i>=0;i--){
            int idx = mapI.get(heights[i]);
            names[k++] = map.get(idx);
        }
        return names;
    }
}
