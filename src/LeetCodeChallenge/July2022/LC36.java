package LeetCodeChallenge.July2022;

import java.util.HashSet;

public class LC36 {

    public static void main(String[] args) {
        String[][] s ={
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
//        isValidSudoku(s);
    }

    public static boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char ch = board[i][j];
                if(ch=='.') continue;
                if(!set.add(ch+ " in "+i) || !set.add(ch+" in"+j) || !set.add(ch+" in row and col"+i/3+"-"+j/3) ) return false;
            }
        }
        return true;
    }



}
