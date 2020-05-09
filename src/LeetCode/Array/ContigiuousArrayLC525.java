package LeetCode.Array;

import java.util.HashMap;

/*
 @author Myvin Barboza
 13/04/20 3:30 PM 
 */
//01101110
public class ContigiuousArrayLC525 {

    static int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int count=0;
        int max_size=0;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]==0)count+=-1;
            else count+=+1;
            if(map.containsKey(count)){
                max_size=Math.max(max_size,i-map.get(count));
            }
            else map.put(count,i);
        }
        return max_size;
    }


    public static void main(String[] args) {
    int nums[]={0,1,1,0,1,1,1,0};
        System.out.println(findMaxLength(nums));
    }
}