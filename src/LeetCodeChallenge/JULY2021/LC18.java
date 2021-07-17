package LeetCodeChallenge.JULY2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int low = j + 1;
                int high = nums.length - 1;
                while (low < high) {
                    int sum = nums[low] + nums[high] + nums[i] + nums[j];
                    if (sum < target) {
                        low++;
                    } else if (sum > target) {
                        high--;
                    } else {
                        list.add(Arrays.asList(nums[low], nums[high], nums[i], nums[j]));

                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;

                        low++;
                        high--;
                    }
                    while(j!=i+1 && nums[j] == nums[j+1])j++;
                }
                while(i+1 <nums.length && nums[i] == nums[i+1])i++;
            }
        }

        return list;
    }

}
