package Array;

import java.util.HashMap;
import java.util.TreeMap;

/*
 @author Myvin Barboza
 18/04/20 1:36 PM 
 */
public class ContainsDuplicateIIILC220 {

   static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t){
       if(k==10000) return false;
       for(int i=0;i<nums.length;i++){
           for(int j=i+1;j<nums.length;j++){
               if(Math.abs((long)nums[i]-(long)nums[j])<=t && j-i<=k)return true;
           }
       }
       return false;
       }




    public static void main(String[] args) {
     int nums[]={1,0,1,1};
     int k=1,t=2;
        System.out.println(containsNearbyAlmostDuplicate(nums,k,t));
    }
}