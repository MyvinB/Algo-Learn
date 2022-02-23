package Company.MorganStanley;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author mmichaelbarboza
 * on 10:37 AM 2/22/2022
 * Time Taken:
 */
public class LC349 {

    public static void main(String[] args) {

    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            set.add(nums1[i]);
        }
        for(int j=0;j<nums2.length;j++){
            if(set.contains(nums2[j])){
                set.remove(nums2[j]);
                res.add(nums2[j]);
            }
        }
        return res.stream().mapToInt(k->k).toArray();
    }
}
