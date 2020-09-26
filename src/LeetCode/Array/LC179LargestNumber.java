package LeetCode.Array;/*
 @author Myvin Barboza
 26/09/20 12:04 PM 
 */

import java.util.Arrays;

public class LC179LargestNumber {
    public String largestNumber(int[] nums) {
        String arr[]=Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(arr,(str1,str2)->((str2+str1).compareTo(str1+str2)));
        return Arrays.stream(arr).reduce((x, y)->x.equals("0")?y:x+y).get();
    }

}
