package LeetCode.Array;/*
 @author Myvin Barboza
 05/08/20 10:40 AM 
 */

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LC414ThirdMaximumNumber {

    public int thirdMaxPQ(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            if(set.add(n)) {
                pq.offer(n);
                if(pq.size() > 3 ) pq.poll();
            }
        }
        if(pq.size() == 2) pq.poll();
        return pq.peek();
    }

    public int thirdMax (int[] nums) {
        int min=nums[0];
        for(int i=0;i<nums.length;i++){
            min=Math.min(nums[i],min);
        }
        int max1=min;
        int max2=min;
        int max3=min;
        for(int num :nums){
            if(num>max1){
                max3=max2;
                max2=max1;
                max1=num;
            }
            else if(num<max1 && num>max2){
                max3=max2;
                max2=num;
            }
            else if(num<max2 && num>max3){
                max3=num;
            }
        }

        return  max3==max2?max1:max3;
    }

}
