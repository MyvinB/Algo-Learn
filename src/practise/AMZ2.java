package practise;

import java.util.ArrayList;
import java.util.List;

public class AMZ2 {

    public static void main(String args[]) {
        System.out.println(minMoves(12, new int[]{20,14,13,15,14,18,10,14,17,10,14,11}, 6));
    }

    public static int minMoves(int n, int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < k; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = i; j < n; j += k) {
                list.add(arr[j]);
            }

            count +=(list.size() - lengthOfLIS(list.stream().mapToInt(Integer::intValue).toArray()));
        }
        return count;

    }

    public static int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }
}
