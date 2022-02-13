package LeetCodeChallenge.Feb2022;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author mmichaelbarboza
 * on 8:33 AM 2/13/2022
 * Time Taken:
 */
public class LContest2 {

    public static void main(String[] args) {
//        countOperations(10,10);
        minimumOperations(new int[]{2,2});
    }
    //Solved but optimisation possible include divisions and modulus operation
    public static int countOperations(int num1, int num2) {
        int count=0;
        while(num1!=0 && num2!=0){
            if(num1<num2){
                num2= num2-num1;
            }else num1=num1-num2;
            count++;
        }
        return count;
    }
    //Fail partially solved the problem though
    public static int minimumOperations(int[] nums) {
        HashMap<Integer,Integer> mapEven = new HashMap<>();
        HashMap<Integer,Integer> mapOdd = new HashMap<>();
        PriorityQueue<int[]> pqEven = new PriorityQueue<>((a,b)->(b[1]-a[1]));
        PriorityQueue<int[]> pqOdd = new PriorityQueue<>((a,b)->(b[1]-a[1]));
        for(int i=0;i<nums.length;i++){
            if(i%2==0) mapEven.put(nums[i], mapEven.getOrDefault(nums[i],0)+1);
            else mapOdd.put(nums[i], mapOdd.getOrDefault(nums[i],0)+1);
        }
        int even = 0;
        int odd =0;
        int maxCount=0;
        for(Integer key:mapEven.keySet()){
            if(mapEven.get(key)>maxCount ){
                even = key;
                maxCount = mapEven.get(key);
            }
            pqEven.offer(new int[]{key, mapEven.get(key)});
        }
        maxCount=0;
        for(Integer key:mapOdd.keySet()){
            if(mapOdd.get(key)>maxCount ){
                odd = key;
                maxCount = mapOdd.get(key);
            }
            pqOdd.offer(new int[]{key, mapOdd.get(key)});
        }
        if(even==odd){
            if(mapEven.get(even)>mapOdd.get(odd)){
                while(!pqEven.isEmpty() &&  (pqEven.peek()[0] ==even )){
                    pqEven.poll();
                }
                even = pqEven.poll()[0];
            }else{
                while(!pqEven.isEmpty() &&  (pqEven.peek()[0] ==even )){
                    pqEven.poll();
                }
                even = pqEven.poll()[0];
            }

        }
        int totalCount=0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0 && nums[i]!= even)totalCount++;
            if(i%2!=0 && nums[i]!= odd) totalCount++;
        }
        System.out.println(totalCount);
        return totalCount;
    }
}
