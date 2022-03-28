package Contest.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author mmichaelbarboza
 * on 5:15 AM 3/28/2022
 * Time Taken:
 */
public class MaximumValueofKCoinsFromPiles {

    public static void main(String[] args) {
        List<List<Integer>> piles = new ArrayList<>();
        piles.add(Arrays.asList(1,100,3));
        piles.add(Arrays.asList(7,8,9));
        System.out.println(maxValueOfCoins(piles,2));
    }
    //Waiting to upsolve first practising 0/1 knapsack
    public static int maxValueOfCoins(List<List<Integer>> piles, int k) {
        return 0;
    }
}
