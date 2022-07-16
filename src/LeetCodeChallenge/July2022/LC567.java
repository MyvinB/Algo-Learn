package LeetCodeChallenge.July2022;

public class LC567 {

    public static void main(String[] args) {

    }
    int mod = 1000000007;
    int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Long memo[][][] = new Long[m][n][maxMove+1];
        return (int)findMemoHelper(m,n,memo,maxMove,startRow,startColumn);
    }

    public long findMemoHelper(int m,int n,Long memo[][][],int maxMove,int i,int j){
        if(maxMove<0) return 0;
        if(i<0 || j<0 || i>=m || j>=n) return 1;
        if(memo[i][j][maxMove]!=null) return memo[i][j][maxMove];
        long noOfWays =0;
        for(int[] d: dir){
            int nr = d[0]+i;
            int nc= d[1]+j;
            noOfWays += findMemoHelper(m,n,memo,maxMove-1,nr,nc);
        }
        noOfWays = noOfWays%mod;
        memo[i][j][maxMove] = noOfWays;
        return memo[i][j][maxMove];
    }
}
