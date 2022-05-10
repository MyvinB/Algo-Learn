package Contest.Upsolve;

import java.util.HashSet;

public class LC2261 {

    public static void main(String[] args) {

    }

    public int countDistinct(int[] nums, int k, int p) {
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            int count = 0;
            StringBuilder sb = new StringBuilder();
            for(int j=i;j<nums.length;j++){
                if(nums[i]%p==0) count++;
                if(count>k) break;
                sb.append(nums[j]+"_");
                set.add(sb.toString());
            }
        }
        return set.size();
    }
}
