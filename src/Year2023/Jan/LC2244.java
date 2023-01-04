package Year2023.Jan;

import java.util.Arrays;
import java.util.HashMap;

public class LC2244 {

    public static void main(String[] args) {
        int[] t = new int[]{2,2,3,3,2,4,4,4,4,4};
        int[] p = new int[]{7,7,7,7,7,7};
        int[] e = new int[]{5,5,5,5};
        int[] h = new int[]{66,66,63,61,63,63,64,66,66,65,66,65,61,67,68,66,62,67,61,64,66,60,69,66,65,68,63,60,67,62,68,60,66,64,60,60,60,62,66,64,63,65,60,69,63,68,68,69,68,61};
        System.out.println(minimumRounds(h));
    }

    public static int minimumRounds(int[] tasks) {
        int round = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<tasks.length;i++){
            map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
        }
        System.out.println(map);
        for(int i:map.values()){
            if(i==1) return -1;
            else round += (i+2)/3;
        }
        return round;
    }
}
