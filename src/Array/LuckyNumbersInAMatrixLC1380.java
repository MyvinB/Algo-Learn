package Array;

/*
 @author Myvin Barboza
 15/03/20 2:45 PM 
 */

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LuckyNumbersInAMatrixLC1380 {
    static List<Integer> luckyNumbers(int[][] mat) {
        List<Integer> a = new ArrayList<>();
        HashSet<Integer> set = new HashSet<Integer>();
        int n = mat[0].length;
        int m = mat.length;
        int max = 0, min = 0;
        for (int i = 0; i < n; i++) {
            max = mat[0][i];
            for (int j = 1; j < m; j++) {

                if (mat[j][i] > max) max = mat[j][i];
            }
            set.add(max);

        }
        System.out.println(set);
        for (int i = 0; i < m; i++) {
            min = mat[i][0];
            for (int j = 0; j < n; j++) {
                if (mat[i][j] < min) min = mat[i][j];
            }
            if (set.contains(min)) a.add(min);
        }
        return a;
    }

    public static void main(String[] args) {
        int mat[][] = {{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}};


        System.out.println(luckyNumbers(mat));
    }
}