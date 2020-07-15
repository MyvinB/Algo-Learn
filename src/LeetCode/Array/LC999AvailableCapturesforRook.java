package LeetCode.Array;/*
 @author Myvin Barboza
 15/07/20 12:19 PM 
 */

public class LC999AvailableCapturesforRook {

    public int numRookCaptures(char[][] board) {
        for(int i=0;i<board.length;i++){
            for (int j=0;j<board[i].length;j++){
                if(board[i][j]=='R')return count(board,i,j);
            }
        }
        return  -1;
    }


    public int count(char[][] board,int p,int q){
        int count=0;
        for(int i=p+1;i<board.length;i++){
            if(board[i][q]=='B') break;
            if(board[i][q]=='p'){count++; break;}
        }

        for(int i=p-1;i>=0;i--){
            if(board[i][q]=='B') break;
            if(board[i][q]=='p'){count++; break;}
        }

        for(int j=q-1;j>=0;j--){
            if(board[p][j]=='B') break;
            if(board[p][j]=='p'){count++; break;}
        }

        for(int j=q+1;j<board[p].length;j++){
            if(board[p][j]=='B') break;
            if(board[p][j]=='p'){count++; break;}
        }
        return count;
    }

}
