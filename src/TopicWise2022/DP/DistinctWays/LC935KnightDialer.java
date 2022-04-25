package TopicWise2022.DP.DistinctWays;

/**
 * @author mmichaelbarboza
 * on 9:24 AM 4/25/2022
 * Time Taken:
 */
public class LC935KnightDialer {

    public static void main(String[] args) {

    }
    int[][] dir = new int[][]{{-2,1},{2,1},{2,-1},{-2,-1},{-1,2},{1,2},{-1,-2},{1,-2}};
    Long[][][]dp;
    int mod = 1000000007;
    public int knightDialer(int n) {
        dp= new Long[4][3][n+1];
        long s = 0;
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                s += paths(i,j,n)%mod;
                s = s%mod;
            }
        }
        return (int)s;
    }

    private long paths(int i,int j, int n){
        //We are outside the board return 0
        if(i<0 || j<0 || i>= 4 || j>=3 || (i==3 & j!=1)){
            return 0;
        }
        //we reach end hence we count one distinct way
        if(n==1) return 1;

        if(dp[i][j][n]!=null) return dp[i][j][n];
        long s = 0;
        for(int[] d:dir){
            int ni = i + d[0];
            int nj = j + d[1];
            s+=paths(ni,nj,n-1)%mod;
        }
        dp[i][j][n] = s;
        return s;

    }
}
