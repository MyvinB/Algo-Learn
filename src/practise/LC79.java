package practise;

/**
 * @author mmichaelbarboza
 * on 3:38 PM 11/29/2021
 */
public class LC79 {

    public static void main(String[] args) {
        char[][] a = {{'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        System.out.println(exist(a,"SEE"));

    }

    public static boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(board,i,j,word,0)) return true;
            }
        }
        return false;
    }


    public static boolean dfs(char[][] board, int i,int j,String word,int wIndex){
        if(wIndex==word.length()) return true;
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]!=word.charAt(wIndex) || board[i][j]=='*') return false;
        int[][] dir= new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        board[i][j] = '*';
        boolean check = false;
        for(int[] d:dir){
         check = check ||dfs(board,i+d[0],j+d[1],word,wIndex+1);
        }
        board[i][j] = word.charAt(wIndex);
        return check;
    }
}
