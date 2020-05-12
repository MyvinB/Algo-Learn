package LeetCode.Array;
/*
 @author Myvin Barboza
 11/05/20 5:16 PM 
 */

public class FloodFillLC733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfs(image,sr,sc,newColor,image[sr][sc]);
        return image;
     
    }


    static void dfs(int[][] image, int i, int j,int newColor,int color){
        if(i<0 ||i>=image.length || j<0 || j>=image[i].length||image[i][j]==newColor){
            return;
        }
        if(image[i][j]==color){
            image[i][j]=newColor;
            dfs(image,i-1,j,newColor,color);
            dfs(image,i+1,j,newColor,color);
            dfs(image,i,j-1,newColor,color);
            dfs(image,i,j+1,newColor,color);
        }
    }
}