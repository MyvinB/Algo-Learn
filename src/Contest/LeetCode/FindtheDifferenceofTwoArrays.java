package Contest.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author mmichaelbarboza
 * on 6:46 PM 3/27/2022
 * Time Taken:
 */
public class FindtheDifferenceofTwoArrays {

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3};
        int[] b = new int[]{2,4,6};
        System.out.println(findDifference(a,b));
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> setCommon = new HashSet<>();
        int n = nums1.length;
        int m = nums2.length;
        List<List<Integer>> resF = new ArrayList<>();
        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();
        resF.add(res1);
        resF.add(res2);
        for(int i=0;i<nums1.length;i++){
            set.add(nums1[i]);
        }
        for(int i=0;i< nums2.length;i++){
            if(set.contains(nums2[i])){
                setCommon.add(nums2[i]);
            }
        }
        for(int i =0;i<n;i++){
            if(!setCommon.contains(nums1[i])){
                res1.add(nums1[i]);
                setCommon.add(nums1[i]);
            }
        }
        for(int i =0;i<m;i++){
            if(!setCommon.contains(nums2[i])){
                res2.add(nums2[i]);
                setCommon.add(nums2[i]);
            }
        }

        return resF;
    }
}
