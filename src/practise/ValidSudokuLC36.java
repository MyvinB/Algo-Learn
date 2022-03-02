package practise;

import java.util.HashSet;
import java.util.Set;

/*
 @author Myvin Barboza
 24/04/20 11:08 AM 
 */public class ValidSudokuLC36 {

    static boolean isValidSudoku(String[][] board) {
        Set<String> set= new HashSet<>();
        for (int i = 0; i <9 ; i++) {
            for (int j = 0; j <9 ; j++) {
                String ch=board[i][j];
                        if(ch!=".")
                        if(!set.add( ch+ "seen in row" +i)|| !set.add(ch+"seen in col"+j)||
                        !set.add(ch+"seen in row and col" +i/3+"-"+j/3)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s[][]={
                {"5","3",".",".","7",".",".",".","."},
                {"6","3",".","1","9","5",".",".","."},
                {".","9","8",".",".",".",".","6","."},
                {"8",".",".",".","6",".",".",".","3"},
                {"4",".",".","8",".","3",".",".","1"},
                {"7",".",".",".","2",".",".",".","6"},
                {".","6",".",".",".",".","2","8","."},
                {".",".",".","4","1","9",".",".","5"},
                {".",".",".",".","8",".",".","7","9"}
        };
        System.out.println(isValidSudoku(s));
    }
}