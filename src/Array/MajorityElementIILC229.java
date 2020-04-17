package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 @author Myvin Barboza
 16/04/20 4:04 PM 
 */
public class MajorityElementIILC229 {
    static List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list=new ArrayList<>();
        int count=nums.length/3;
        int temp=0;
        for (int i = 0; i < nums.length ; i++) {
            temp++;
            if(i<nums.length-1&& nums[i]!=nums[i+1]){
                if(temp>count) list.add(nums[i]);
                temp=0;
            }
        }
        if(temp>count)list.add(nums[nums.length-1]);
        return list;

    }

    public static void main(String[] args) {
    int num[]={3,2,3};
        System.out.println(majorityElement(num));
    }
}