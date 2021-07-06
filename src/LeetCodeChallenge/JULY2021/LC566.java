package LeetCodeChallenge.JULY2021;

import java.util.ArrayList;
import java.util.List;

public class LC566 {

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if((m*n) != (r*c)) return mat;
        int nR=0,nC=0;
        int res[][] = new int[r][c];
        for(int i=0;i<m;i++){
            for (int j = 0; j <n ; j++) {
                if(nC==c){
                    nR++;
                    nC=0;
                }
                res[nR][nC] = mat[i][j];
                nC++;
            }
        }

        return res;
    }
}
