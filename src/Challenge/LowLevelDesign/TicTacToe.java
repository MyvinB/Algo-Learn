package Challenge.LowLevelDesign;/*
 @author Myvin Barboza
 10/08/20 10:58 AM 
 */

public class TicTacToe {
    private final int[][] board;
    private final int[] rowSum,colSum;
    private final int n;
    private int diagSum,diagRevSum;
    private int rep=2;
    public TicTacToe(final int n) {
        this.n=n;
        this.board = new int[n][n];
        this.rowSum = new int[n];
        this.colSum=new int[n];
    }

    /*
    * @param player is either 0 or 1
    * @param row in move row index
    * @param col is in move col index
    * @return winner +1 is  player 1 ,-1 if player 2 and zero if nothing
    * @exception throw IllegalArgumentException if there is an illegal move
    * */
    public int move(int player,int row,int col) throws IllegalArgumentException{
        int n=board.length;
        if(rep==player){
            throw new IllegalArgumentException("Not the players chance");
        }
        else if(row<0 ||col<0 || row>=n|| col>=n){
            throw new  IllegalArgumentException("Board is not in position");
        }
        else if(board[row][col]!=0){
            throw new IllegalArgumentException("Position already filled");
        }
        else if(player!=0 && player!=1){
            throw new IllegalArgumentException("Invalid Player");
        }
            rep=player;
            player=player==0?1:-1;
            board[row][col]=player;
            rowSum[row]+=player;
            colSum[col]+=player;
            if(row==col) {
                diagSum+=player;
            }
            if(row==n-1-col) {
            diagRevSum+=player;
            }
            if(n==Math.abs(diagSum) || n==Math.abs(diagRevSum)  || n==Math.abs(colSum[col]) || n==Math.abs(rowSum[row])){
                return player;
            }
            return 0;
        }

         public static void main(String[] args) {
            TicTacToe board=new TicTacToe(3);
            int dp[][]={{0,0,0},{1,0,1},{0,1,0},{1,1,2},{0,2,0}};
            for(int arr[]:dp){
                System.out.println(board.move(arr[0],arr[1],arr[2]));
            }

        }
    }

