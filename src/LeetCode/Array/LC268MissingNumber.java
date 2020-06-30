package LeetCode.Array;/*
 @author Myvin Barboza
 30/06/20 12:40 PM 
 */

import java.util.HashSet;

public class LC268MissingNumber {

    public int missingNumber(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int a:nums)set.add(a);
        for(int i=0;i<=nums.length;i++)
            if(!set.contains(i)) return i;

        return -1;
    }
}
