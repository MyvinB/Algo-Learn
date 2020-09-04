package LeetCode.Array;

import java.util.TreeSet;

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
    //
    static boolean containsNearbyAlmostDuplicateTree(int[] nums, int k, int t) {
        //1 5 9 1 5 9

            //1 5 9 1 5 9
            TreeSet<Long> set=new TreeSet<>();
            for(int i=0;i<nums.length;i++){

                Long floor=set.floor(1L*nums[i]+t);
                Long ceil=set.ceiling(1L*nums[i]-t);

                if( (floor!=null && floor>=nums[i] ) || (ceil!=null && ceil<=nums[i]) )
                    return true;
                set.add(1L * nums[i]);
                if(i>=k){
                    set.remove(1L*nums[i-k]);
                }
            }
            return false;

    }


    public static void main(String[] args) {
     int nums[]={1,5,9,1,5,9};
     int k=2,t=3;
        System.out.println(containsNearbyAlmostDuplicateTree(nums,k,t));
    }
}