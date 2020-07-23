package LeetCode.DFSANDBFSONLY;/*
 @author Myvin Barboza
 23/07/20 8:50 AM 
 */

public class LC529Minesweeper {
    public static void main(String[] args) {

    }

    public char[][] updateBoard(char[][] board, int[] click) {
        dfs(board,click[0],click[1]);
        return board;
    }
    static int direction[][]={{0,1},{0,-1},{1,0},{-1,0},{-1,1},{1,1},{1,-1},{-1,-1}};


    static void dfs(char[][] board,int x,int y){
        //terminal condition
        if(board[x][y]=='M' || board[x][y]=='X'){
            board[x][y]='X';
            return;
        }
        int num=0;
        //used for counting the number of mines
        for(int dir[]:direction){
            int row=x+dir[0];
            int col=y+dir[1];
            if(row>=0 && row<board.length && col>=0 && col<board[0].length && board[row][col]=='M'){
                num++;
            }

        }
        if(num>0){
            board[x][y]=(char)(num+'0');
            return;
        }
        else{
            board[x][y]='B';

        }

        for(int dir[]:direction){
            int row=x+dir[0];
            int col=y+dir[1];
            if(row>=0 && row<board.length && col>=0 && col<board[0].length && board[row][col]=='E'){
                dfs(board,row,col);
            }

        }



    }


}
