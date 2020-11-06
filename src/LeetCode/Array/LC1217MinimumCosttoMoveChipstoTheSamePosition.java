package LeetCode.Array;

import java.util.Arrays;

public class LC1217MinimumCosttoMoveChipstoTheSamePosition {
    public int minCostToMoveChips(int[] position) {
        int[] cnt = new int[2];
        for (int chip : position)
            ++cnt[chip % 2];
        System.out.println(Arrays.toString(cnt));
        return Math.min(cnt[0], cnt[1]);
    }
}
