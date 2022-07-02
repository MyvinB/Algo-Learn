package LeetCodeChallenge.July2022;

public class LC37 {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char k='1';k<='9';k++){
                        if(valid(i,j,k,board)){
                            board[i][j] = k;
                            if(solve(board))return true;
                            else board[i][j] = '.';
                        }
                    }
                    // if all the character are tried and there is no sol return false character changes and then back tracks
                    return false;

                }
            }
        }
        //all the set is done correctly return true do it can back track; and move on to the next i or j val
        return true;
    }

    public boolean valid(int row,int col,char ch,char[][] board){
          /*i/3 changes for 0 1 2 ->0
                              3 4 5 ->1
                              6 7 8 ->2


               i%3            0 3 6-> 0
                              1 4 7 ->1
                              2 5 8 ->2

                       also we have a row offset and coloffset its a starting point so we can see only that matrix
            * */
        int rowOffset = 3*(row/3),colOffset = 3 * (col/3);
        for(int i=0;i<9;i++){
            if(board[row][i]==ch) return false;
            if(board[i][col]==ch) return false;
            if(board[rowOffset+i/3][colOffset+i%3]==ch) return false;
        }
        return true;
    }
}
