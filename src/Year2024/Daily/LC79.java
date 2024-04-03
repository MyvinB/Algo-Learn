package Year2024.Daily;

public class LC79 {



    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfsHelper(board,i,j,word,0)){
                 return true;
                }
            }
        }
        return false;
    }


    public boolean dfsHelper(char[][] board, int i, int j,String word, int k){
        int m = board.length;
        int n = board[0].length;
        //Boundary conditions
        if(word.length() == k){
            return true;
        }
        if(i == m || j ==n || i<0 || j<0 || word.charAt(k)!= board[i][j] ){
            return false;
        }
        board[i][j] = '#';
        int[][] dir = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        boolean res = false;
        for(int[] d :dir){
            res = res ||  dfsHelper(board,i+d[0],j+d[1],word,k+1);
        }
        board[i][j] = word.charAt(k);
        return res;
    }
}
