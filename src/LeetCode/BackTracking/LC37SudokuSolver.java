package LeetCode.BackTracking;/*
 @author Myvin Barboza
 17/06/20 6:14 AM 
 */

public class LC37SudokuSolver {


    static void solveSudoku(char[][] board) {
    if(board==null && board.length==0) return;
    solve(board);


    }

    static boolean  solve(char a[][]){
        for (int i = 0; i <a.length ; i++) {
            for (int j = 0; j <a[0].length ; j++) {
                if(a[i][j]=='.') {
                    for (char c = '1'; c <='9'; c++) {
                        if (isValid(i, j, c, a)) {
                            a[i][j] = c;
                            if (solve(a)) return true;
                            else a[i][j] = '.';
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

    static boolean isValid(int row,int col,char c,char a[][]){
        int rowOffset=(row/3)*3,colOffset=(col/3)*3;


        for(int i=0;i<9;i++){
            //check in colum of  char
            if(a[i][col]==c) return false;
            if(a[row][i]==c) return false;
            /*i/3 changes for 0 1 2 ->0
                              3 4 5 ->1
                              6 7 8 ->2


               i%3            0 3 6-> 0
                              1 4 7 ->1
                              2 5 8 ->2

                       also we have a row offset and coloffset its a starting point so we can see only that matrix
            * */
            if(a[rowOffset+i/3][colOffset+i%3]==c) return false;
        }
        return true;
    }
    static void printMA(char a[][]){
        for (int i = 0; i <a.length ; i++) {
            for (int j = 0; j <a[0].length ; j++) {

                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char a[][]={
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'},
        };
        printMA(a);

        System.out.println();
        solveSudoku(a);
        printMA(a);

    }
}
