package LeetCodeChallenge.JUNE2022;

public class LC867TransposeMatrix {

    public static void main(String[] args) {

    }

    public int[][] transpose(int[][] matrix) {
        int i=0,j=0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] res = new int[m][n];
        for(i=0;i<n;i++){
            for(j=0;j<m;j++){
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }
}
