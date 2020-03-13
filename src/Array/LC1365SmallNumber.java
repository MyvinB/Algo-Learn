package Array;/*
 @author Myvin Barboza
 3/13/2020 12:02 PM
 Type:Easy
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class LC1365SmallNumber {

    static int[] smallerNumbersThanCurrent(int[] nums) {
        int a[]= Arrays.copyOf(nums,nums.length);
        Arrays.sort(a);
        TreeMap<Integer ,Integer> map=new TreeMap<>();
        for (int i = 0; i <nums.length ; i++) {
        if(!map.containsKey(a[i])){
            map.put(a[i],i);
        }
        }
        System.out.println(map);
        for(int i=0;i<nums.length;i++){
            nums[i]=map.get(nums[i]);
        }
        return nums;

    }

    public static void main(String[] args) {
        int a[]={8,1,2,2,3};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(a)));

    }
}
