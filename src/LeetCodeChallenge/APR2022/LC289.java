package LeetCodeChallenge.APR2022;

/**
 * @author mmichaelbarboza
 * on 7:38 AM 4/12/2022
 * Time Taken:
 */
public class LC289 {

    public static void main(String[] args) {
        int[][] t = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(t);
    }

    public static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int count1 = 0;
                board[i][j]= board[i][j]*100;
                for(int[] d:dir){
                    int x = i+d[0];
                    int y = j+ d[1];
                    if(x<0 ||y<0||x>=m||y>=n) continue;
                    if(board[x][y]/100==1 || board[x][y]==1){
                        count1++;
                    }
                }
                int newVal = 0;
                if(count1==3){
                    newVal = 1;
                }
                else if(count1<2){
                    newVal = 0;
                }
                else if(count1>3){
                    newVal = 0;
                }
                System.out.println(i+" "+j+" ->"+ newVal+"count var"+count1);
                board[i][j] = board[i][j] + 10*newVal;
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
            board[i][j] = board[i][j]/10;
            board[i][j] = board[i][j]%10;
            }
        }

    }
}
