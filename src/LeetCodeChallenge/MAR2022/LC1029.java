package LeetCodeChallenge.MAR2022;

import java.util.*;

/**
 * @author mmichaelbarboza
 * on 12:51 PM 3/25/2022
 * Time Taken:
 */
public class LC1029 {

    public static void main(String[] args) {

    }

    public int twoCitySchedCost(int[][] costs) {
        int totalCostForA = 0;
        int n = costs.length/2;
        List<Integer> temp = new ArrayList<>();
        for(int[] p:costs){
            totalCostForA += p[0];
            temp.add(p[1]-p[0]);
        }
        Collections.sort(temp);
        for(int i=0;i<n;i++){
            totalCostForA += temp.get(i);
        }
        return totalCostForA;
    }
}
