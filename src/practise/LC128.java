package practise;

import java.util.HashSet;

/**
 * @author mmichaelbarboza
 * on 8:31 PM 11/23/2021
 */
public class LC128 {
    public static void main(String[] args) {
        int nums[] = new int[]{100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int count = 0;
        for (int n : set) {
            if (!set.contains(n + 1)) {
                int m = n - 1;
                while (set.contains(m)) {
                    m--;
                }
                count = Math.max(count, n - m);
            }
        }

        return count;
    }
}
