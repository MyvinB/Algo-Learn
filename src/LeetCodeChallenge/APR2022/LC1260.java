package LeetCodeChallenge.APR2022;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author mmichaelbarboza
 * on 7:52 AM 4/11/2022
 * Time Taken:
 */
public class LC1260 {

    public static void main(String[] args) {
        int[][] t = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        shiftGrid(t,1);
    }

    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int[][] temp = new int[grid.length][grid[0].length]; // took temp grid
        int n = grid.length;
        int m = grid[0].length;
        int mod = n * m;
        k = k % mod; // minimize the k value
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int p = j + k; // defines which col
                int r = p / (m); // defines which row
                if (p < m) {
                    temp[i][p] = grid[i][j];
                } else {
                    temp[(i + r) % n][p % m] = grid[i][j];
                }
            }
        }
        // making temp grid into list
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> c = new LinkedList<>();
        for (int[] t : temp) {
            for (int i : t) {
                c.add(i);
            }
            result.add(c);
        }
        return result;
    }
}
