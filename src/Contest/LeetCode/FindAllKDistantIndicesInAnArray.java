package Contest.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author mmichaelbarboza
 * on 8:08 AM 3/13/2022
 * Time Taken:
 */
public class FindAllKDistantIndicesInAnArray {

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,2,2,2};
        System.out.println(findKDistantIndices(nums,2,2));
    }

    public static List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==key){
                for(int j=0;j<=n;j++){
                    if(Math.abs(j-i)<=k && !set.contains(j)){
                        set.add(j);
                        res.add(j);
                    }
                }
            }
        }

        return res;
    }
}
