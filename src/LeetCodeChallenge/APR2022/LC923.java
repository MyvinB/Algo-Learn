package LeetCodeChallenge.APR2022;

import java.util.HashMap;

/**
 * @author mmichaelbarboza
 * on 11:56 AM 4/6/2022
 * Time Taken:
 */
public class LC923 {

    public static void main(String[] args) {
        int[] t = new int[]{1,1,2,2,3,3,4,4,5,5};
        threeSumMulti(t,8);
    }
    public static int threeSumMulti(int[] arr, int target) {
        HashMap<Integer,Long> map = new HashMap<>();
        for(int t:arr){
            map.put(t,map.getOrDefault(t,0l)+1);
        }
        long count = 0;
        for(int el1:map.keySet()){
            for(int el2:map.keySet()){
                int el3 = target - el1 - el2;
                if(map.containsKey(el3)){
                    long freq1 = map.get(el1);
                    long freq2 = map.get(el2);
                    long freq3 = map.get(el3);
                    if(el1 == el2 && el2 == el3){
                        count+= (freq1 * (freq1-1) * (freq1-2))/6;
                    }else if(el1 == el2 && el2!=el3){
                        count+= (freq1 *(freq1-1))/2 *freq3;
                    }else if(el1<el2 && el2<el3){
                        count += freq1 * freq2 * freq3;
                    }
                }
                count = count%1000000007;
            }
        }
        return (int)count;
    }
}
