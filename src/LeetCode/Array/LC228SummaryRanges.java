package LeetCode.Array;

import java.util.ArrayList;
import java.util.List;

public class LC228SummaryRanges {
    public static void main(String[] args) {
    int a[]= {0,2,3,4,6,8,9};
        System.out.println(summaryRanges(a));
    }

    static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < nums.length; i++) {
            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
                end++;
                i++;
            }
            if (start == end) {
                list.add(String.valueOf(nums[start]));
            } else {
                list.add(nums[start] + "->" + nums[end]);
            }
            end++;
            start = end;

        }
        return list;
    }
}
