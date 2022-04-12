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
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int c = j+ k;
                int r =  c/m;
                if(c<m){
                    temp[i][c] = grid[i][j];
                }
                else{
                    temp[(i+r)%n][c%m] = grid[i][j];
                }
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> tempList = new ArrayList<>();
            for(int j=0;j<m;j++){
                tempList.add(temp[i][j]);
            }
            list.add(tempList);
        }
        return list;
    }
}
