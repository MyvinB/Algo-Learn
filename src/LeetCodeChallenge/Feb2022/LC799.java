package LeetCodeChallenge.Feb2022;

import java.io.BufferedInputStream;

/**
 * @author mmichaelbarboza
 * on 3:19 PM 3/5/2022
 * Time Taken:
 */
public class LC799 {
    public static void main(String[] args) {

    }

    public double champagneTower(int poured, int query_row, int query_glass) {
      double[][] qnt = new double[101][101];
      qnt[0][0] = poured;
      for(int i=0;i<query_row;i++){
          for(int j=0;j<=query_glass;j++){
              double remaining = Math.max(qnt[i][j]-1,0);
              //one down and left (i) and right (i+1)
              qnt[i+1][j] +=  remaining/2;
              qnt[i+1][j+1] += remaining/2;
          }
      }

      return Math.min(qnt[query_row][query_glass],1);
    }
}
