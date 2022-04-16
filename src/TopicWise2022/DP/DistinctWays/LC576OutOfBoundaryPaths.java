package TopicWise2022.DP.DistinctWays;

/**
 * @author mmichaelbarboza
 * on 2:49 PM 4/16/2022
 * Time Taken:
 */
public class LC576OutOfBoundaryPaths {
    public static void main(String[] args) {

    }
    int mod = 1000000007;
    int[][] dir =new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Long[][][] memo = new Long[m][n][maxMove+1];
        return (int)findMemoHelper(m,n,maxMove,startRow,startColumn,memo);
    }

    public long findMemoHelper(int m,int n,int maxMove, int i, int j,Long memo[][][]){
        if(maxMove<0) return 0;
        if(i<0 ||j<0 ||i>=m ||j>=n) return 1;
        if(memo[i][j][maxMove]!=null) return memo[i][j][maxMove];
        long noOfWays =0;
        for(int[] d:dir){
            int nr = d[0]+i;
            int nc =d[1]+j;
            noOfWays += findMemoHelper(m,n,maxMove-1,nr,nc,memo);
        }
        noOfWays = noOfWays%mod;
        memo[i][j][maxMove] = noOfWays;
        return memo[i][j][maxMove];
    }
}
