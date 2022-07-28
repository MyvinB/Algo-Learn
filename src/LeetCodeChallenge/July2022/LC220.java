package LeetCodeChallenge.July2022;

import java.util.TreeSet;

public class LC220 {

    public static void main(String[] args) {

        int[] t = new int[]{6,2,3,9};
        System.out.println(containsNearbyAlmostDuplicate(t, 2, 3));
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //Use of long assume 2 as one number and -2 as another 2-(-2) is 4 now imagine 2 to be a big number this addition will lead to overflow so long to handle it all
        //Second know that i-j<=k when we minus from i-j there is one extra so k will be one more taking eg of [1,2,3,1] here first and last index is the ans
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for(int i=0;i<n;i++){
            Long floor = set.floor(1L * nums[i]);
            Long ceil = set.ceiling(1L * nums[i]);
            if(floor!=null && (nums[i]-floor)<=t) return true;
            if(ceil!=null && (ceil-nums[i])<=t) return true;
            set.add(1L*nums[i]);
            if(i+1>k){
                set.remove(1L*nums[i-k]);
            }
        }
        return false;
    }


}
