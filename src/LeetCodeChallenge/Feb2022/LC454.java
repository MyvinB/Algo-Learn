package LeetCodeChallenge.Feb2022;

import java.util.HashMap;

/**
 * @author mmichaelbarboza
 * on 10:13 AM 2/3/2022
 * Time Taken:00:10:00
 */
public class LC454 {

    public static void main(String[] args) {

    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j< nums2.length;j++){
                int sum = nums1[i]+nums2[j];
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }
        int count=0;
        for(int i=0;i<nums3.length;i++){
            for(int j=0;j<nums4.length;j++){
                int sum = -(nums3[i]+nums4[j]);
                if(map.containsKey(sum)){
                 count+= map.get(sum);
                }
            }
        }
        return count;
    }
}
