package LeetCode.DP;/*
 @author Myvin Barboza
 17/06/20 1:49 PM 
 */

import java.util.Arrays;

public class LC130SurroundedRegions {


    static void solve(char[][] board) {

        int r=board.length;
        int c=board[0].length;

        for (int i = 0; i <r ; i++) {
            if(board[i][0]=='O')dfs(board,i,0);
            if(board[i][c-1]=='O')dfs(board,i,c-1);
        }

        for (int j = 0; j <c ; j++) {
            if(board[0][j]=='O')dfs(board,0,j);
            if(board[r-1][j]=='O')dfs(board,r-1,j);
        }


        for (int i = 0; i <r ; i++) {
            for (int j = 0; j <c ; j++) {
                if(board[i][j]=='*') board[i][j]='O';
                else if(board[i][j]=='O') board[i][j]='X';
            }
        }
    }

    static void dfs (char board[][],int i,int j){

        if(i== board.length || i<0 || j==board[0].length || j<0 || board[i][j]=='X') return;
        ///to avoid a cyclic patter eg{0,0}{0,0} use this need to return when we see a * and place a * when see a O
        if(board[i][j]=='*') return;
        if(board[i][j]=='O') board[i][j]='*';
        dfs(board,i+1,j);
        dfs(board,i-1,j);
        dfs(board,i,j+1);
        dfs(board,i,j-1);
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};

        solve(board);

        System.out.println(Arrays.deepToString(board));
    }

}
