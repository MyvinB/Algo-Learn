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
    //Instead of using 10th and 100th place to store values think of a bit wise soln
    /*
     *   Check for one
    * if(board[d[0]+i][d[1]+j]==1 || board[d[0]+i][d[1]+j]==2) live++;
    * Conditional value change
    * if(board[i][j]==0 && live==3) board[i][j]=3;
      if(board[i][j]==1 && (live<2 || live>3)) board[i][j]=2;
      *
      * Finally change the value to the required with %2; the concept is same but it's saved in a single number itself also here we do not makes changes for certain cases in the below we make changes irrespective
    *
    * */
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
                    //changed value or not changed value
                    if(board[x][y]/100==1 ||board[x][y]==1){
                        count1++;
                    }
                }
                int newVal = board[i][j]/100;
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
