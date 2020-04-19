package DP;

import java.sql.Array;
import java.util.Arrays;

/*
 @author Myvin Barboza
 18/04/20 3:31 PM 
 */
public class WordSearchLC79 {

/*
char a[][] = {{"A","B","C","E"},
                {"S","F","C","S"},
                {"A","D","E","E"}};

                [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
"ABCB"

                Ankita

                [["C","A","A"],["A","A","A"],["B","C","D"]]
"AAB"

* */
    static boolean exist(char[][] board, String word) {
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[i].length ; j++) {

                if(dp(board,i,j,word,0)) return true;
            }
        }
        return false;
    }

    static boolean dp(char[][] board,int i,int j,String word,int k){

        if(word.length()==k) return true;
        if(i<0 ||j<0) return false;
        if(i>=board.length ||j>=board[i].length) return false;
        boolean check=false;
        if(word.charAt(k)==board[i][j] ){
            board[i][j]='*';
           if( dp(board,i+1,j,word,k+1) ||
            dp(board,i-1,j,word,k+1) ||
            dp(board,i,j+1,word,k+1)||
            dp(board,i,j-1,word,k+1)) check=true ;
            board[i][j]=word.charAt(k);
            return check;
        }
         return false;



    }



    public static void main(String[] args) {
        char a[][] = {{'C','*','A'},
                {'A','A','A'},
                {'B','C','D'}};
        String word="AAB";
        System.out.println(word.length());
        System.out.println(exist(a,"AAB"));
    }
}